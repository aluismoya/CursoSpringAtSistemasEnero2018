package com.curso.spring.simpsons.front.services;

import java.net.URISyntaxException;
import java.util.List;

import com.curso.spring.simpsons.front.dto.Personaje;

public interface ServicioPersonajes {

	Personaje consultaId(String id);

	List<Personaje> consultaTodos();

	Personaje consultaPadre(String id);

	List<Personaje> consultaApellidos(String apellidos);

	String insercion(Personaje personaje) throws URISyntaxException;

	void borrado(String id);

}
