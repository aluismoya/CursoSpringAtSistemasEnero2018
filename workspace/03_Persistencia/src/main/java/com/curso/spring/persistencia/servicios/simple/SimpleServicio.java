package com.curso.spring.persistencia.servicios.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.persistencia.dao.PersonaDao;
import com.curso.spring.persistencia.entidades.Persona;
import com.curso.spring.persistencia.servicios.Servicio;

@Service
@Transactional
public class SimpleServicio implements Servicio {

	@Autowired
	private PersonaDao pesonaDao;
	
	/* (non-Javadoc)
	 * @see com.curso.spring.persistencia.servicios.Servicio#altaEnElSistemaDeUnaPersona(com.curso.spring.persistencia.entidades.Persona)
	 */
	@Override
	public void altaEnElSistemaDeUnaPersona(Persona persona){
		pesonaDao.insertarPersona(persona);
	}
	
}
