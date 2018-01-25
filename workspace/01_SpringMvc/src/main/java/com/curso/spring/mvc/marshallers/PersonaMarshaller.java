package com.curso.spring.mvc.marshallers;

import org.springframework.stereotype.Component;

import com.curso.spring.mvc.dto.Persona;

@Component
public class PersonaMarshaller implements Marshall<com.curso.spring.mvc.entities.Persona, Persona> {

	/* (non-Javadoc)
	 * @see com.curso.spring.mvc.marshallers.Marshall#marshall(com.curso.spring.mvc.entities.Persona)
	 */
	@Override
	public Persona marshall(com.curso.spring.mvc.entities.Persona personaEntity){
		
		Persona personaDto = new Persona();
		
		personaDto.setId(personaEntity.getId());
		personaDto.setNombre(personaEntity.getNombre());
		personaDto.setSexo(personaEntity.getSexo());
		
		return personaDto;
	}
	
	/* (non-Javadoc)
	 * @see com.curso.spring.mvc.marshallers.Marshall#unMarshall(com.curso.spring.mvc.dto.Persona)
	 */
	@Override
	public com.curso.spring.mvc.entities.Persona unMarshall(Persona personaDto){
		com.curso.spring.mvc.entities.Persona personaEntity = new com.curso.spring.mvc.entities.Persona();
		
		personaEntity.setId(personaDto.getId());
		personaEntity.setNombre(personaDto.getNombre());
		personaEntity.setSexo(personaDto.getSexo());
		
		return personaEntity;
	}
	
}
