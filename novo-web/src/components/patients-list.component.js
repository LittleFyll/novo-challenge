import React, { Component } from "react";
import PatientDataService from "../services/patient.service";

const average = arr => arr.reduce((a,b) => a + b, 0) / arr.length;

export default class PatientsList extends Component {
  constructor(props) {
    super(props);
    this.retrievePatients = this.retrievePatients.bind(this);
    this.retrievePatientVitals = this.retrievePatientVitals.bind(this);
    this.refreshList = this.refreshList.bind(this);
    this.setActivePatient = this.setActivePatient.bind(this);
    this.deletePatient = this.deletePatient.bind(this);

    this.state = {
      patients: [],
      currentPatient: null,
      currentIndex: -1
    };
  }

  componentDidMount() {
    this.retrievePatients();
  }

  retrievePatients() {
    PatientDataService.getAll()
      .then(response => {
        this.setState({
          patients: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  retrievePatientVitals(patientId) {
    PatientDataService.getVitalsByPatientId(patientId)
      .then(response => {
        this.setState({
          currentPatient: {
            ...this.state.currentPatient,
            vitals: {
              ...response.data,
              heartRateMin: Math.min(...response.data.heartRate),
              heartRateMax: Math.max(...response.data.heartRate),
              heartRateAvg: average(response.data.heartRate).toFixed(1),
              temperatureMin: Math.min(...response.data.temperature),
              temperatureMax: Math.max(...response.data.temperature),
              temperatureAvg: average(response.data.temperature).toFixed(1),
              oxygenSaturationMin: Math.min(...response.data.oxygenSaturation),
              oxygenSaturationMax: Math.max(...response.data.oxygenSaturation),
              oxygenSaturationAvg: average(response.data.oxygenSaturation).toFixed(1),
            }
          }
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  refreshList() {
    this.retrievePatients();
    this.setState({
      currentPatient: null,
      currentIndex: -1
    });
  }

  setActivePatient(patient, index) {
    this.setState({
      currentPatient: {
        ...patient,
        age: this.calculateAge(patient.birthday)
      },
      currentIndex: index
    });
    this.retrievePatientVitals(patient.id);
  }

  deletePatient() {    
    PatientDataService.delete(this.state.currentPatient.id)
      .then(response => {
        this.refreshList();
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  calculateAge(birthday) {
    if (birthday == null) return "Not Available";

    var today = new Date();
    var birthDate = new Date(birthday);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    return age;
  }

  render() {
    const { patients, currentPatient, currentIndex } = this.state;

    return (
      <div className="list row">

        <div className="col-md-6">
          <h4>Patients List</h4>

          <ul className="list-group">
            {patients &&
              patients.map((patient, index) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActivePatient(patient, index)}
                  key={index}
                >
                  {patient.firstName} {patient.lastName}
                </li>
              ))}
          </ul>
        </div>
        <div className="col-md-6">
          {currentPatient ? (
            <div>
              <h4>Patient</h4>
              <div>
                <label>
                  <strong>Name:</strong>
                </label>{" "}
                {currentPatient.firstName} {currentPatient.lastName}
              </div>
              <div>
                <label>
                  <strong>Age:</strong>
                </label>{" "}
                {currentPatient.age}
              </div>
              <div>
                <label>
                  <strong>Sexe:</strong>
                </label>{" "}
                {currentPatient.sexe}
              </div>
              <div>
                <label>
                  <strong>Email:</strong>
                </label>{" "}
                {currentPatient.email}
              </div>
              <div>
                <label>
                  <strong>Heart Rate (bpm):</strong>
                </label>{" "}
                {currentPatient.vitals?.heartRate.join(", ")}
              </div>
              <div>
                <label>
                  <strong>Heart Rate min/max/avg:</strong>
                </label>{" "}
                {currentPatient.vitals?.heartRateMin}/{currentPatient.vitals?.heartRateMax}/{currentPatient.vitals?.heartRateAvg}
              </div>
              <div>
                <label>
                  <strong>Temperature (C):</strong>
                </label>{" "}
                {currentPatient.vitals?.temperature.join(", ")}
              </div>
              <div>
                <label>
                  <strong>Temperature min/max/avg:</strong>
                </label>{" "}
                {currentPatient.vitals?.temperatureMin}/{currentPatient.vitals?.temperatureMax}/{currentPatient.vitals?.temperatureAvg}
              </div>
              <div>
                <label>
                  <strong>SpO2 (%):</strong>
                </label>{" "}
                {currentPatient.vitals?.oxygenSaturation.join(", ")}
              </div>
              <div>
                <label>
                  <strong>SpO2 min/max/avg:</strong>
                </label>{" "}
                {currentPatient.vitals?.oxygenSaturationMin}/{currentPatient.vitals?.oxygenSaturationMax}/{currentPatient.vitals?.oxygenSaturationAvg}
              </div>
              <button
              className="m-3 btn btn-sm btn-danger"
              onClick={this.deletePatient}
            >
              Delete Patient
            </button>

            </div>
          ) : (
            <div>
              <br />
              <p>Please click on a Patient...</p>
            </div>
          )}
        </div>
      </div>
    );
  }
}