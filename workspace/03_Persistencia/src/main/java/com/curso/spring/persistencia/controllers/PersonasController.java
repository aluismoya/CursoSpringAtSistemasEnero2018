package com.curso.spring.persistencia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.persistencia.entidades.Persona;
import com.curso.spring.persistencia.servicios.Servicio;

@RestController
public class PersonasController {

	@Autowired
	private Servicio servicio;
	
	@PostMapping(path="/persona", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertar(@RequestBody Persona persona){
		servicio.altaEnElSistemaDeUnaPersona(persona);
		
		return persona.toString();
	}
	
}
