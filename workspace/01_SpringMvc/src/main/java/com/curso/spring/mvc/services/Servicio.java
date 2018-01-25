package com.curso.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.curso.spring.mvc.dto.Persona;
import com.curso.spring.mvc.marshallers.Marshall;
import com.curso.spring.mvc.persistence.PersonaRepository;

@Service
public class Servicio {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("personaMarshaller")
	private Marshall<com.curso.spring.mvc.entities.Persona, Persona> personaMashaller;
	
	public void altaPersona(Persona persona){
		personaRepository.save(personaMashaller.unMarshall(persona));
	}
	
}
