package com.curso.spring.simpsons.front.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.curso.spring.simpsons.front.dto.Personaje;
import com.curso.spring.simpsons.front.services.ServicioPersonajes;

@Controller
@RequestMapping("/Personaje")
public class PersonajesController {

//	@Autowired
//	private View detalleView;
	
	@Autowired
	private ServicioPersonajes servicio;
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public String consultaId(@PathVariable String id, Map<String,Object> model) {

		Personaje personaje = servicio.consultaId(id);
		
		model.put("personaje", personaje);
		
		return "personaje/detalle";
//		return new InternalResourceView("/WEB-INF/jsps/personaje/detalle.jsp")
//		sreturn detalleView;
	}

	@GetMapping
	public String consultaTodos(Map<String,Object> model) {
		
		List<Personaje> resultado = servicio.consultaTodos();
		
		model.put("resultado", resultado);
		
		return "personaje/listado";
	}

	/*
	@GetMapping(path="/{id}/padre")
	public String consultaPadre(@PathVariable String id) {
		return new Personaje("hommer", "abraham", "hommer", "Simpson");
	}

	@GetMapping(params="apellidos")
	public String consultaApellidos(@RequestParam("apellidos") String apellidos) {
		return Arrays.asList(new Personaje[]{new Personaje("hommer", "abraham", "hommer", apellidos), new Personaje("bart", "hommer", "bart", "Simpson"), new Personaje("lisa", "hommer", "lisa", "Simpson")});
	}

	@PostMapping
	public String insercion(@ModelAttribute Personaje personaje) throws URISyntaxException {
		System.out.println("ALTA: " + personaje);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(new URI("http://localhost:8080/PersonajesSimpsons/Personaje/" + personaje.getId()));
		
		return new ResponseEntity<>("Este dato le llega al cliente en el body", headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public String borrado(@PathVariable String id) {
		System.out.println("BORRADO: " + id);
	}
*/
}
