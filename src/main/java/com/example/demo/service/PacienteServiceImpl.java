package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Paciente;
import com.example.demo.repository.IPacienteRepository;
import com.example.demo.service.to.PacienteTO;

@Service
public class PacienteServiceImpl implements IPacienteService {
	
	@Autowired
	private IPacienteRepository pacienteRepository;

	@Override
	public void registrar(PacienteTO paciente) {
		this.pacienteRepository.insertar(this.convertirPaciente(paciente));

	}

	

	@Override
	public PacienteTO buscar(Integer id) {
		return this.convertirPacienteTO(this.pacienteRepository.buscar(id));
	}
	
	private Paciente convertirPaciente(PacienteTO paci) {

		Paciente p = new Paciente();
		p.setApellido(paci.getApellido());
		p.setCedula(paci.getCedula());
		p.setCodigoSeguro(paci.getCodigoSeguro());
		p.setFechaNacimiento(paci.getFechaNacimiento());
		p.setGenero(paci.getGenero());
		p.setNombre(paci.getNombre());
		p.setEstatura(paci.getEstatura());
		p.setPeso(paci.getPeso());
		p.setId(paci.getId());
		return p;

	}
	
	private PacienteTO convertirPacienteTO(Paciente paci) {

		PacienteTO p = new PacienteTO();
		p.setApellido(paci.getApellido());
		p.setCedula(paci.getCedula());
		p.setCodigoSeguro(paci.getCodigoSeguro());
		p.setFechaNacimiento(paci.getFechaNacimiento());
		p.setGenero(paci.getGenero());
		p.setNombre(paci.getNombre());
		p.setEstatura(paci.getEstatura());
		p.setPeso(paci.getPeso());
		p.setId(paci.getId());
		return p;

	}
	
	@Override
	public PacienteTO buscarPorCedula(String cedula) {
		return this.convertirPacienteTO(this.pacienteRepository.buscarPorCedula(cedula));
	}

	@Override
	public Paciente buscarPorCedulaP(String cedula) {
		return this.pacienteRepository.buscarPorCedula(cedula);
	}


	

}
