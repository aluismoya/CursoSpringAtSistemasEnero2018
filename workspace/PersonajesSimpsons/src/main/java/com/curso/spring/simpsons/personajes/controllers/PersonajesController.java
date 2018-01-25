package com.curso.spring.simpsons.personajes.controllers;

import java.util.Arrays;
import java.util.List;

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

import com.curso.spring.simpsons.personajes.dto.Personaje;

@RestController
@RequestMapping("/Personaje")
public class PersonajesController {

	@RequestMapping(path="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Personaje consultaId(@PathVariable String id) {
		return new Personaje(id, "Hommer", id, "Simpson");
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Personaje> consultaTodos() {
		return Arrays.asList(new Personaje[]{new Personaje("bart", "hommer", "bart", "Simpson"), new Personaje("lisa", "hommer", "lisa", "Simpson")});
	}

	@GetMapping(path="/{id}/padre", produces=MediaType.APPLICATION_JSON_VALUE)
	public Personaje consultaPadre(@PathVariable String id) {
		return new Personaje("hommer", "abraham", "hommer", "Simpson");
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, params="apellidos")
	public List<Personaje> consultaApellidos(@RequestParam("apellidos") String apellidos) {
		return Arrays.asList(new Personaje[]{new Personaje("hommer", "abraham", "hommer", apellidos), new Personaje("bart", "hommer", "bart", "Simpson"), new Personaje("lisa", "hommer", "lisa", "Simpson")});
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insercion(@RequestBody Personaje personaje) {
		System.out.println("ALTA: " + personaje);
		return new ResponseEntity<>(headers, status);
	}

	@DeleteMapping("/{id}")
	public void borrado(@PathVariable String id) {
		System.out.println("BORRADO: " + id);
	}

}
