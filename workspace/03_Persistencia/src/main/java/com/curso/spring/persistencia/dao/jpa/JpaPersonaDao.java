package com.curso.spring.persistencia.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.curso.spring.persistencia.dao.PersonaDao;
import com.curso.spring.persistencia.entidades.Persona;

@Repository
public class JpaPersonaDao implements PersonaDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insertarPersona(Persona persona) {
		em.persist(persona);
	}

}
