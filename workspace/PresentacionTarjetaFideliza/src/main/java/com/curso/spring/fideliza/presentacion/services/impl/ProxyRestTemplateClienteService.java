package com.curso.spring.fideliza.presentacion.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.curso.spring.fideliza.presentacion.dto.Cliente;
import com.curso.spring.fideliza.presentacion.dto.Usuario;
import com.curso.spring.fideliza.presentacion.services.IClienteService;

@Component
public class ProxyRestTemplateClienteService implements IClienteService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Cliente registrarCliente(Cliente cliente) {
		return null;
	}

	@Override
	public Cliente obtenerCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente obtenerCliente(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
