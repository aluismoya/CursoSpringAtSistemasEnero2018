package com.curso.spring.simpsons.back.services;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.spring.simpsons.back.dto.Personaje;

@Service
public class ServicioPersonajesBasic implements ServicioPersonajes {

	@Override
	public Personaje consultaId(String id) {
		return new Personaje(id, "Hommer", id, "Simpson");
	}

	@Override
	public List<Personaje> consultaTodos() {
		return Arrays.asList(new Personaje[]{new Personaje("bart", "hommer", "bart", "Simpson"), new Personaje("lisa", "hommer", "lisa", "Simpson")});
	}

	@Override
	public Personaje consultaPadre(String id) {
		return new Personaje("hommer", "abraham", "hommer", "Simpson");
	}

	@Override
	public List<Personaje> consultaApellidos(String apellidos) {
		return Arrays.asList(new Personaje[]{new Personaje("hommer", "abraham", "hommer", apellidos), new Personaje("bart", "hommer", "bart", "Simpson"), new Personaje("lisa", "hommer", "lisa", "Simpson")});
	}

	@Override
	public String insercion(Personaje personaje) throws URISyntaxException {
		System.out.println("ALTA: " + personaje);
		return personaje.getNombre();
	}

	@Override
	public void borrado(String id) {
		System.out.println("BORRADO: " + id);
	}

}
