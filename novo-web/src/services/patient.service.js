import http from "../http-commons";

class PatientDataService {
  getAll() {
    return http.get("/patients");
  }

  get(id) {
    return http.get(`/patients/${id}`);
  }

  create(data) {
    return http.post("/patients", data);
  }

  delete(id) {
    return http.delete(`/patients/${id}`);
  }

  getVitalsByPatientId(patientId) {
    return http.get(`/vitalSigns/${patientId}`);
  }
}

export default new PatientDataService();