package com.example.demo.service.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;

import org.springframework.hateoas.RepresentationModel;

public class CitaMedicaNuevaTO extends RepresentationModel<CitaMedicaNuevaTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer numeroCita;

	private LocalDateTime fechaCita;

	private BigDecimal valorCita;

	private String lugarCita;

	private String cedulaDoctor;

	private String cedulaPeciante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(Integer numeroCita) {
		this.numeroCita = numeroCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getCedulaDoctor() {
		return cedulaDoctor;
	}

	public void setCedulaDoctor(String cedulaDoctor) {
		this.cedulaDoctor = cedulaDoctor;
	}

	public String getCedulaPeciante() {
		return cedulaPeciante;
	}

	public void setCedulaPeciante(String cedulaPeciante) {
		this.cedulaPeciante = cedulaPeciante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}