package com.curso.spring.persistencia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.persistencia.entidades.Persona;

@Repository
@Transactional
public class PersonaDao {

	@Autowired
	private SessionFactory sf;
	
	public void insertarPersona(Persona persona){
		//Lo instancia el TransactionManager
		Session session = sf.getCurrentSession();
		
		session.persist(persona);//Hibernate se encarga de construir la consulta de INSERT
		session.flush();
	}
	
}
