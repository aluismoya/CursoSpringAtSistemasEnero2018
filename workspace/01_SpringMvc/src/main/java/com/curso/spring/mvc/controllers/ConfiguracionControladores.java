package com.curso.spring.mvc.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.curso.spring.mvc.dto.Genero;

/**
 * Permite que todos los controladores gestionados por RequestMappingHandlerMapping, tengan esta config comun,
 * dentro del paquete indicado
 * @author Formacion
 *
 */
@ControllerAdvice("com.curso.spring.mvc.controllers")
//@SessionAttributes("generos")
public class ConfiguracionControladores {

	//Obligatorio ponerla la clave con la que queremos acceder al objeto como atributo de request
	@ModelAttribute("generos")
	public Genero[] generos() {
		//Invocamos la logica para recuperar los datos del Genero
		return new Genero[] {Genero.MASCULINO, Genero.FEMENINO};
	}
	
}
