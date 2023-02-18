package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Doctor;
import com.example.demo.modelo.Paciente;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Doctor doctor) {
		this.entityManager.persist(doctor);
		
	}
	
	@Override
	public Doctor buscarPorCedula(String cedula) {
		TypedQuery<Doctor> myQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula=:cedula",
				Doctor.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

}
