package com.curso.spring.mvc.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.curso.spring.mvc.services.Servicio;

@Controller
@RequestMapping("/otroSaludo")
public class OtroControlador {
	
	//Beans de logica (Vista, servicio)
	@Autowired
	@Qualifier("otraVista")
	private View vista;
	
	@Autowired
	private Servicio servicio;
	
	@RequestMapping(path = "/bienvenida", method = RequestMethod.GET)
	public String bienvenida(Map<String, Object> model) {
		return "miVista";
	}

	@RequestMapping(path = "/despedida", method = RequestMethod.GET)
	public View despedida(Model model) {
		model.addAttribute("saludo", "Adios con el corazon!");
		return vista;
	}

}
