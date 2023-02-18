package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CitaMedica;
import com.example.demo.repository.ICitaMedicaRepository;
import com.example.demo.service.to.CitaMedicaActualizarTO;
import com.example.demo.service.to.CitaMedicaNuevaTO;
import com.example.demo.service.to.CitaPendienteTO;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void agendarCitaMedica(CitaMedicaNuevaTO citaMedica) {
		this.citaMedicaRepository.insertar(this.convertirCitaMedica(citaMedica));
	}

	@Override
	public void actualizacionCitaMedica(CitaMedicaActualizarTO cita) {
		this.citaMedicaRepository.actualizar(this.convertirCitaMedicaActualizar(cita));

	}

	@Override
	public List<CitaPendienteTO> citasPendientes(String cedula) {
		List<CitaMedica> lista = this.citaMedicaRepository.buscarCitasPendientes(cedula);

		List<CitaPendienteTO> listaFinal = lista.stream().map(cita -> this.convertirCitaPendiente(cita))
				.collect(Collectors.toList());

		return listaFinal;
	}

	private CitaMedica convertirCitaMedica(CitaMedicaNuevaTO cita) {
		CitaMedica citaM = new CitaMedica();
		citaM.setId(cita.getId());
		citaM.setNumeroCita(cita.getNumeroCita());
		citaM.setFechaCita(cita.getFechaCita());
		citaM.setValorCita(cita.getValorCita());
		citaM.setLugarCita(cita.getLugarCita());

		citaM.setDoctor(this.doctorService.buscarPorCedulaD(cita.getCedulaDoctor()));
		citaM.setPaciente(this.pacienteService.buscarPorCedulaP(cita.getCedulaPeciante()));

		return citaM;
	}

	private CitaMedica convertirCitaMedicaActualizar(CitaMedicaActualizarTO cita) {
		CitaMedica citaM = this.citaMedicaRepository.buscarNumeroCita(cita.getNumeroCita());
		// citaM.setId(cita.getId());
		citaM.setDiagnostico(cita.getDiagnostico());
		citaM.setFechaProximaCita(cita.getFechaProximaCita());
		citaM.setReceta(cita.getReceta());

		return citaM;
	}

	private CitaPendienteTO convertirCitaPendiente(CitaMedica cita) {
		CitaPendienteTO citaM = new CitaPendienteTO();
		citaM.setId(cita.getId());
		citaM.setNumeroCita(cita.getNumeroCita());
		citaM.setFechaCita(cita.getFechaCita());
		citaM.setValorCita(cita.getValorCita());
		citaM.setLugarCita(cita.getLugarCita());
		return citaM;
	}

	@Override
	public CitaMedica buscarNumeroCita(Integer numeroCita) {
		return this.citaMedicaRepository.buscarNumeroCita(numeroCita);
	}
	
}
