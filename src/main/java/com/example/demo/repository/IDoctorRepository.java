package com.example.demo.repository;

import com.example.demo.modelo.Doctor;

public interface IDoctorRepository {

	public void insertar(Doctor doctor);

	Doctor buscarPorCedula(String cedula);
}
