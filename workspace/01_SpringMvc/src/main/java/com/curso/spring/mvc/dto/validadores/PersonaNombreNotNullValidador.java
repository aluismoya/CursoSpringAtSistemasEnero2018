package com.curso.spring.mvc.dto.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.curso.spring.mvc.dto.Persona;

public class PersonaNombreNotNullValidador implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		System.out.println(arg0);
		return Persona.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {
		
		/* Invocamos la lógica necesaria para realizar la validación, por ejemplo, invocar a un servicio que
		 * nos valide si el nombre está dentro de una base de datos.
		 */
		
		System.out.println("Nombre: " + ((Persona)arg0).getNombre());
		
		if (((Persona)arg0).getNombre() == null || ((Persona)arg0).getNombre().equals("")) {
			e.rejectValue("nombre", "formulario.persona.error.nombre", "Mi propio error de NoTNull");
		}
	}

}
