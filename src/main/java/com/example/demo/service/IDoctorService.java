package com.example.demo.service;

import com.example.demo.modelo.Doctor;
import com.example.demo.service.to.DoctorTO;

public interface IDoctorService {
	public void registrar(DoctorTO doctor);

	public DoctorTO buscarPorCedula(String cedulaDoctor);
	
	public Doctor buscarPorCedulaD(String cedula);
}
