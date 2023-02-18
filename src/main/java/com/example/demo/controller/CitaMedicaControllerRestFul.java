package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ICitaMedicaService;
import com.example.demo.service.to.CitaMedicaActualizarTO;
import com.example.demo.service.to.CitaMedicaNuevaTO;
import com.example.demo.service.to.CitaPendienteTO;


@RestController
@RequestMapping("/citasMedicas")
@CrossOrigin
public class CitaMedicaControllerRestFul {

	@Autowired 
	private ICitaMedicaService citaMedicaService;

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void agendarCita(@RequestBody CitaMedicaNuevaTO cita) {
		this.citaMedicaService.agendarCitaMedica(cita);
	}

	@PutMapping(path = "/{numeroCita}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void actualizarCita(@RequestBody CitaMedicaActualizarTO cita, @PathVariable("numeroCita") Integer numeroCita) {
		cita.setNumeroCita(numeroCita);
		this.citaMedicaService.actualizacionCitaMedica(cita);
	}
	@GetMapping(path = "/doctor/{cedula}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CitaPendienteTO> consultarCitasPendientes(@PathVariable("cedula") String cedula){
		return this.citaMedicaService.citasPendientes(cedula);
	}


}

