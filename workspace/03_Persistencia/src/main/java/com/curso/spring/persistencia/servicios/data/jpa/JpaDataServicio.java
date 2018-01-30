package com.curso.spring.persistencia.servicios.data.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.persistencia.dao.data.jpa.PersonaDao;
import com.curso.spring.persistencia.entidades.Persona;
import com.curso.spring.persistencia.servicios.Servicio;

@Service
public class JpaDataServicio implements Servicio{

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	public void altaEnElSistemaDeUnaPersona(Persona persona) {
		personaDao.save(persona);
	}

}
