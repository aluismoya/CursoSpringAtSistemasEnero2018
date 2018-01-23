package com.curso.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/saludo")
public class Controlador {
	
	@RequestMapping(path = "/bienvenida", method = RequestMethod.GET)
	public String bienvenida() {
		new Controlador();
		new Controlador();
		return "miVista";
	}

	@RequestMapping(path = "/despedida", method = RequestMethod.GET)
	public ModelAndView despedida() {
		return null;
	}

}
