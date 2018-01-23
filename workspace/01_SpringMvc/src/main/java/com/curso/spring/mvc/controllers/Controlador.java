package com.curso.spring.mvc.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import com.curso.spring.mvc.dto.Persona;
import com.curso.spring.mvc.services.Servicio;

@Controller
@RequestMapping("/saludo")
public class Controlador {
	
	//Beans de logica (Vista, servicio)
	@Autowired
	@Qualifier("miVista")
	private View vista;
	
	@Autowired
	private Servicio servicio;
	
	/**
	 * Metodo, busca un mensaje de bienvenida por su id (es decir, tenemos varios mensajes de bienvenida) y lo completa con la informacion del objeto Persona que recibe por parametros
	 * @param model
	 * @param persona
	 * @param identificador
	 * @return
	 */
	@RequestMapping(path = "/bienvenida/{id}", method = RequestMethod.GET)
	public String bienvenida(Map<String, Object> model, Persona persona, @PathVariable(name="id") int identificador) {
		return "miVista";
	}

	/**
	 * Metodo que busca un mensaje de despedida para retornarlo
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/despedida", method = RequestMethod.GET)
	public View despedida(Model model, @RequestParam int id) {
		model.addAttribute("saludo", "Adios con el corazon!");
		return vista;
	}

	/**
	 * Metodo que recibiendo una PErsona en formato JSON, la cambia el nombre y la retorna en formato XML
	 * @param persona
	 * @param nombreNuevo
	 * @return
	 */
	@RequestMapping(path="/cambioDeNombre", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody public Persona cambiarElNombreALaPersona(@RequestBody Persona persona, @RequestParam(required=true) String nombreNuevo) {
		persona.setNombre(nombreNuevo);
		return persona;
	}
	
}
