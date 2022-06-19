import React, { Component } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AddPatient from "./components/add-patient.component";
import PatientsList from "./components/patients-list.component";

class App extends Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            Novo-Challenge
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/patients"} className="nav-link">
                Patients
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/add"} className="nav-link">
                Add
              </Link>
            </li>
          </div>
        </nav>

        <div className="container mt-3">
          <Routes>
            <Route exact path="/" element={<PatientsList/>} />
            <Route exact path="/patients" element={<PatientsList/>} />
            <Route exact path="/add" element={<AddPatient/>} />
          </Routes>
        </div>
      </div>
    );
  }
}

export default App;