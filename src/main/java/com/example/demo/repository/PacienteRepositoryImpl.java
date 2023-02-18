package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);
	}
	
	@Override
	public Paciente buscar(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}
	
	@Override
	public Paciente buscarPorCedula(String cedula) {
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula=:cedula",
				Paciente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

}
