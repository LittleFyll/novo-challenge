import React, { Component } from "react";
import PatientDataService from "../services/patient.service";

export default class AddPatient extends Component {
  constructor(props) {
    super(props);
    this.onChangeFirstName = this.onChangeFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangeBirthday = this.onChangeBirthday.bind(this);
    this.onChangeSexe = this.onChangeSexe.bind(this);
    this.savePatient = this.savePatient.bind(this);
    this.newPatient = this.newPatient.bind(this);

    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      birthday: "",
      selectedSexe: "",
      submitted: false
    };
  }

  onChangeFirstName(e) {
    this.setState({
      firstName: e.target.value
    });
  }

  onChangeLastName(e) {
    this.setState({
      lastName: e.target.value
    });
  }

  onChangeEmail(e) {
    this.setState({
      email: e.target.value
    });
  }

  onChangeBirthday(e) {
    this.setState({
      birthday: e.target.value
    });
  }

  onChangeSexe(e) {
    this.setState({
      selectedSexe: e.target.value
    });
  }

  savePatient() {
    var data = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      birthday: this.state.birthday,
      email: this.state.email,
      sexe: this.state.selectedSexe,
    };

    PatientDataService.create(data)
      .then(response => {
        this.setState({
          submitted: true
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  newPatient() {
    this.setState({
      firstName: "",
      lastName: "",
      email: "",
      birthday: "",
      selectedSexe: "",
      submitted:false
    });
  }

  render() {
    return (
      <div className="submit-form">
        {this.state.submitted ? (
          <div>
            <h4>You submitted successfully!</h4>
            <button className="btn btn-success" onClick={this.newPatient}>
              Add
            </button>
          </div>
        ) : (
          <div>
            <div className="form-group">
              <label htmlFor="title">First Name</label>
              <input
                type="text"
                className="form-control"
                id="firstName"
                required
                value={this.state.firstName}
                onChange={this.onChangeFirstName}
                name="firstName"
              />
            </div>

            <div className="form-group">
              <label htmlFor="lastName">Last Name</label>
              <input
                type="text"
                className="form-control"
                id="lastName"
                required
                value={this.state.lastName}
                onChange={this.onChangeLastName}
                name="lastName"
              />
            </div>

            <div className="form-group">
              <label htmlFor="birthday">Birthday</label>
              <input
                type="date"
                className="form-control"
                id="birthday"
                required
                value={this.state.birthday}
                onChange={this.onChangeBirthday}
                name="birthday"
              />
            </div>

            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input
                type="text"
                className="form-control"
                id="email"
                required
                value={this.state.email}
                onChange={this.onChangeEmail}
                name="email"
              />
            </div>

            <div className="form-group" id="sexe">
              <label htmlFor="sexe">Sexe</label>
              <div className="radio">
                <label>
                  <input
                    type="radio"
                    value="MALE"
                    checked={this.state.selectedSexe === "MALE"}
                    onChange={this.onChangeSexe}
                  />
                  Male
                </label>
              </div>
              <div className="radio">
                <label>
                  <input
                    type="radio"
                    value="FEMALE"
                    checked={this.state.selectedSexe === "FEMALE"}
                    onChange={this.onChangeSexe}
                  />
                  Female
                </label>
              </div>
              <div className="radio">
                <label>
                  <input
                    type="radio"
                    value="NOT_SPECIFIED"
                    checked={this.state.selectedSexe === "NOT_SPECIFIED"}
                    onChange={this.onChangeSexe}
                  />
                  Other
                </label>
              </div>
            </div>

            <button onClick={this.savePatient} className="btn btn-success">
              Submit
            </button>
          </div>
        )}
      </div>
    );
  }
}