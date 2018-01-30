package com.curso.spring.persistencia.dao.data.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.spring.persistencia.entidades.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{

	//SELECT * FROM PERSONAS WHERE NOMBRE = nombre
	List<Persona> findByNombre(String nombre);
	
}
