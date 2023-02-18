package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.CitaMedica;

public interface ICitaMedicaRepository {
	


	void insertar(CitaMedica cita);

	void actualizar(CitaMedica cita);

	List<CitaMedica> buscarCitasPendientes(String cedula);

	CitaMedica buscarNumeroCita(Integer numeroCita);
	
	

}
