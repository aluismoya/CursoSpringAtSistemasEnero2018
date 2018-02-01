package com.curso.spring.fideliza.presentacion.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.fideliza.presentacion.dto.Usuario;

/**
 * Permite que todos los controladores gestionados por
 * RequestMappingHandlerMapping tengan esta config comun dentro del paquete
 * indicado
 * 
 * @author rmaynar
 *
 */
@ControllerAdvice("com.maynar.fideliza.webapp.controller")
@SessionAttributes("usuario")
public class ConfirguracionControladores {
	// Asociado a todas las requests
	@ModelAttribute("usuario")
	public Usuario usuario() {
		return new Usuario();
	}
}
