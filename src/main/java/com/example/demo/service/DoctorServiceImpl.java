package com.example.demo.service;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Doctor;
import com.example.demo.repository.IDoctorRepository;
import com.example.demo.service.to.DoctorTO;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository doctorRepository;

	@Override
	public void registrar(DoctorTO doctor) {

		this.doctorRepository.insertar(this.convertirDoctor(doctor));

	}

	public DoctorTO buscarPorCedula(String cedula) {
		return this.convertirDoctorTO(this.doctorRepository.buscarPorCedula(cedula));
	}
	
	public Doctor buscarPorCedulaD(String cedula) {
		return this.doctorRepository.buscarPorCedula(cedula);
	}


	private Doctor convertirDoctor(DoctorTO doc) {

		Doctor d = new Doctor();
		d.setApellido(doc.getApellido());
		d.setCedula(doc.getCedula());
		d.setCodigoSenescyt(doc.getCodigoSenescyt());
		d.setFechaNacimiento(doc.getFechaNacimiento());
		d.setGenero(doc.getGenero());
		d.setNombre(doc.getNombre());
		d.setNumeroConsultorio(doc.getNumeroConsultorio());

		return d;

	}

	private DoctorTO convertirDoctorTO(Doctor doc) {

		DoctorTO d = new DoctorTO();
		d.setApellido(doc.getApellido());
		d.setCedula(doc.getCedula());
		d.setCodigoSenescyt(doc.getCodigoSenescyt());
		d.setFechaNacimiento(doc.getFechaNacimiento());
		d.setGenero(doc.getGenero());
		d.setNombre(doc.getNombre());
		d.setNumeroConsultorio(doc.getNumeroConsultorio());

		return d;

	}

}
