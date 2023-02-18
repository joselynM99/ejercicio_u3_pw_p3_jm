package com.example.demo.service;

import com.example.demo.modelo.Paciente;
import com.example.demo.service.to.PacienteTO;

public interface IPacienteService {
	public void registrar(PacienteTO paciente);
	
	public PacienteTO buscar(Integer id);

	PacienteTO buscarPorCedula(String cedula);

	Paciente buscarPorCedulaP(String cedula);
}
