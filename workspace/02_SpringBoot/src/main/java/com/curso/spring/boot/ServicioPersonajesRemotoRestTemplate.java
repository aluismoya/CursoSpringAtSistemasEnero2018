package com.curso.spring.boot;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioPersonajesRemotoRestTemplate implements ServicioPersonajes {

	private static final String RESOURCE_URI = "http://localhost:8080/BackSimpsons/Personaje";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Personaje consultaId(String id) {
		HashMap<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		ResponseEntity<Personaje> personajeEntity = restTemplate.getForEntity(RESOURCE_URI + "/{id}", Personaje.class, uriVariables);
		return personajeEntity.getBody();
	}

	@Override
	public List<Personaje> consultaTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personaje consultaPadre(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personaje> consultaApellidos(String apellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insercion(Personaje personaje) throws URISyntaxException {
		ResponseEntity<String> personajeEntity = restTemplate.postForEntity(new URI(RESOURCE_URI), personaje, String.class);
		
		return personajeEntity.getHeaders().getLocation().getRawFragment();
	}

	@Override
	public void borrado(String id) {
		// TODO Auto-generated method stub

	}

}