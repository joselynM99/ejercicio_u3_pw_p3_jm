package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica cita) {
		this.entityManager.persist(cita);

	}

	@Override
	public void actualizar(CitaMedica cita) {
		this.entityManager.merge(cita);

	}

	@Override
	public CitaMedica buscarNumeroCita(Integer numeroCita) {
		TypedQuery<CitaMedica> myQuery = this.entityManager
				.createQuery("SELECT c FROM CitaMedica c WHERE c.numeroCita=:numeroCita", CitaMedica.class);
		myQuery.setParameter("numeroCita", numeroCita);

		return myQuery.getSingleResult();
	}

	@Override
	public List<CitaMedica> buscarCitasPendientes(String cedulaDoctor) {
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery(
				"SELECT c FROM CitaMedica c JOIN FETCH c.doctor d WHERE d.cedula=:cedulaDoctor AND c.diagnostico=null",
				CitaMedica.class);
		myQuery.setParameter("cedulaDoctor", cedulaDoctor);

		return myQuery.getResultList();
	}
}
