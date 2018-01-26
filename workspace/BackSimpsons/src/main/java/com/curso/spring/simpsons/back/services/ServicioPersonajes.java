package com.curso.spring.simpsons.back.services;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.curso.spring.simpsons.back.dto.Personaje;

public interface ServicioPersonajes {

	Personaje consultaId(String id);

	List<Personaje> consultaTodos();

	Personaje consultaPadre(String id);

	List<Personaje> consultaApellidos(String apellidos);

	String insercion(Personaje personaje) throws URISyntaxException;

	void borrado(String id);

}
