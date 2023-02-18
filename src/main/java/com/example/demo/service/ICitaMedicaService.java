package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.CitaMedica;
import com.example.demo.service.to.CitaMedicaActualizarTO;
import com.example.demo.service.to.CitaMedicaNuevaTO;
import com.example.demo.service.to.CitaPendienteTO;

public interface ICitaMedicaService {

	void agendarCitaMedica(CitaMedicaNuevaTO citaMedica);

	void actualizacionCitaMedica(CitaMedicaActualizarTO cita);

	List<CitaPendienteTO> citasPendientes(String cedula);
	
	public CitaMedica buscarNumeroCita(Integer numeroCita);

}
