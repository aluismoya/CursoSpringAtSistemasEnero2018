package com.curso.spring.fideliza.presentacion.services.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.curso.spring.fideliza.presentacion.dto.Oferta;
import com.curso.spring.fideliza.presentacion.services.IOfertasService;

public class ProxyRestTemplateOfertasService implements IOfertasService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Oferta> consultarTodas() {
		try {
			return Arrays.asList(restTemplate.getForEntity(new URI("http://localhost:8280/oferta"), Oferta[].class).getBody());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
