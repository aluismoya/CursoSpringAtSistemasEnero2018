package com.curso.spring.persistencia.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateDao {

	@Autowired
	protected SessionFactory sf;
	
}
