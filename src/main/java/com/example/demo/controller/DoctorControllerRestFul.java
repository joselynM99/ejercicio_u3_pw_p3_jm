package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IDoctorService;
import com.example.demo.service.to.DoctorTO;

@RestController
@CrossOrigin
@RequestMapping("/doctores")
public class DoctorControllerRestFul {
	@Autowired
	private IDoctorService doctorService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void registrarDoctor(@RequestBody DoctorTO doctor) {
		this.doctorService.registrar(doctor);
	}

}
