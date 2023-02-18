package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IPacienteService;
import com.example.demo.service.to.PacienteTO;

@RestController
@CrossOrigin
@RequestMapping("/pacientes")
public class PacienteControllerRestFul {
	@Autowired
	private IPacienteService pacienteService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PacienteTO> registrar(@RequestBody PacienteTO paciente) {

		Link myLink = linkTo(methodOn(PacienteControllerRestFul.class).buscarPorCedula(paciente.getCedula()))
				.withSelfRel();

		paciente.add(myLink);
		this.pacienteService.registrar(paciente);
		return ResponseEntity.status(HttpStatus.OK).body(paciente);
	}

	@GetMapping(path = "/{cedula}")
	public PacienteTO buscarPorCedula(@PathVariable("cedula") String cedula) {
		return this.pacienteService.buscarPorCedula(cedula);
	}

}
