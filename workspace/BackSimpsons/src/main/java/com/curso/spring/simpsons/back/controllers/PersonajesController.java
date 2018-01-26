package com.curso.spring.simpsons.back.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.simpsons.back.dto.Personaje;
import com.curso.spring.simpsons.back.services.ServicioPersonajes;

@RestController
@RequestMapping("/Personaje")
public class PersonajesController {
	
	@Autowired
	private ServicioPersonajes servicio;

	@RequestMapping(path="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Personaje consultaId(@PathVariable String id) {
		return servicio.consultaId(id);
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Personaje> consultaTodos() {
		return servicio.consultaTodos();
	}

	@GetMapping(path="/{id}/padre", produces=MediaType.APPLICATION_JSON_VALUE)
	public Personaje consultaPadre(@PathVariable String id) {
		return servicio.consultaPadre(id);
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, params="apellidos")
	public List<Personaje> consultaApellidos(@RequestParam("apellidos") String apellidos) {
		return servicio.consultaApellidos(apellidos);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insercion(@RequestBody Personaje personaje) throws URISyntaxException {
		
		String id = servicio.insercion(personaje);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(new URI("http://localhost:8080/PersonajesSimpsons/Personaje/" + id));
		
		return new ResponseEntity<>("Este dato le llega al cliente en el body", headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public void borrado(@PathVariable String id) {
		servicio.borrado(id);
	}

}
