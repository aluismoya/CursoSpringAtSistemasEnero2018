package com.curso.spring.fideliza.ofertas.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.curso.spring.fideliza.ofertas.bom.Oferta;
import com.curso.spring.fideliza.ofertas.dao.IOfertasDao;
@Repository
public class OfertasDaoImpl implements IOfertasDao {

	@Autowired
    MongoTemplate mongoTemplate;
 
    final String COLLECTION = "ofertas";
	
	
	public List<Oferta> obtenerTodasOfertas() {
		return mongoTemplate.findAll(Oferta.class, COLLECTION);
	}

	public List<Oferta> obtenerOfertasMes(Date fecha) {
		Query query = new Query(Criteria.where("caducidad").gte(fecha));
        return mongoTemplate.find(query, Oferta.class, COLLECTION);
	}

}
