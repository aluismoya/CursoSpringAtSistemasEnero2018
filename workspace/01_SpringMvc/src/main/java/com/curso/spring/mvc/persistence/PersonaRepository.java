package com.curso.spring.mvc.persistence;

import com.curso.spring.mvc.entities.Persona;

public interface PersonaRepository {

	void save(Persona unMarshall);

}