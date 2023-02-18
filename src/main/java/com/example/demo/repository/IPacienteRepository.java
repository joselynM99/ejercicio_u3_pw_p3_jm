package com.example.demo.repository;

import com.example.demo.modelo.Paciente;

public interface IPacienteRepository {

	public void insertar(Paciente paciente);

	Paciente buscar(Integer id);

	Paciente buscarPorCedula(String cedula);
}
