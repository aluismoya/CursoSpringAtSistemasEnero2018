package com.curso.spring.seguridad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controlador {
	
	@RequestMapping(path = "/bienvenida", method = RequestMethod.GET)
	public String bienvenida() {
		return "bienvenida";
	}

}
