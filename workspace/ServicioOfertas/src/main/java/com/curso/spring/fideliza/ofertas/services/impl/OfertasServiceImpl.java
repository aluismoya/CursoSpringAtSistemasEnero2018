package com.curso.spring.fideliza.ofertas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.fideliza.ofertas.bom.Oferta;
import com.curso.spring.fideliza.ofertas.dao.IOfertasDao;
import com.curso.spring.fideliza.ofertas.services.IOfertasService;
@Service
public class OfertasServiceImpl implements IOfertasService {
	
//	private static Oferta[] ofertas = {new Oferta("Bahamas 2x1", new Date()),new Oferta("República dominicana 2x1", new Date())};
	
	@Autowired
	IOfertasDao ofertasDao;
	
	public List<Oferta> consultarTodas() {
		
		List<Oferta> ofertas = ofertasDao.obtenerTodasOfertas();
		return ofertas;
	}

}
