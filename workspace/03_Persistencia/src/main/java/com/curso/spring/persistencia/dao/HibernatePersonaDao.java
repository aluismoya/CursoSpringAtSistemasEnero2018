package com.curso.spring.persistencia.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.persistencia.entidades.Persona;

@Repository
@Transactional
public class HibernatePersonaDao extends HibernateDao implements PersonaDao {
	
	/* (non-Javadoc)
	 * @see com.curso.spring.persistencia.dao.PersonaDao#insertarPersona(com.curso.spring.persistencia.entidades.Persona)
	 */
	@Override
	public void insertarPersona(Persona persona){
		//Lo instancia el TransactionManager
		Session session = sf.getCurrentSession();
		
		session.persist(persona);//Hibernate se encarga de construir la consulta de INSERT
		session.flush();
	}
	
}
