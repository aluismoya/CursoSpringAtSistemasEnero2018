package com.curso.spring.mvc.controllers;

import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curso.spring.mvc.dto.Persona;

@Controller
public class FormControlador {

	@Autowired
	private MessageSource messageSource;
	
	//Ponemos este objeto en el request, porque formulario.jsp, lo busca, y la primera vez que se renderiza
	//el formulario.jsp al "no pasar por controlador", no existirá el objeto
	@ModelAttribute("persona")
	public Persona persona() {
		return new Persona();
	}
	
	@RequestMapping(path = "/formulario", method = RequestMethod.GET)
	public String iniciarFormulario(Map<String, Object> model) {

		//La logica a comntinuacion, es sustituida por los Metodos anotados por @ModelAttribute
		
		// Invicamos la logica para recuperar los datos del Genero

		// servicio.obtenerGeneros();

		//model.put("generos", new String[] { "Masculino", "Femenino" });

		return "formulario";
	}

	@RequestMapping(path = "/formulario", method = RequestMethod.POST)
	public String procesarFormulario(@Valid @ModelAttribute Persona persona, Errors errors) {
		System.out.println(messageSource.getMessage("formulario.persona.nombre", null, Locale.getDefault())  + errors);
		System.out.println(persona.getNombre() + ", " + persona.getSexo());
		return "formulario";
	}

	@RequestMapping(path = "/registro", method = RequestMethod.POST)
	public String procesarRegistro(@ModelAttribute Persona persona) {
		return "formulario";
	}

}
