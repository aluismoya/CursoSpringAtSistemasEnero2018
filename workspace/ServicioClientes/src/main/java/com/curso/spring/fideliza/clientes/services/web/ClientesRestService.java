package com.curso.spring.fideliza.clientes.services.web;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.fideliza.clientes.dto.ClienteDto;
import com.curso.spring.fideliza.clientes.services.IClientesService;

@RestController
public class ClientesRestService {

	@Autowired
	private IClientesService clientesService;

	@PostMapping(path="/registrar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> nuevo(@RequestBody ClienteDto cliente) throws URISyntaxException
	{
		Long idCliente = clientesService.registrarCliente(cliente);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(new URI("http://......" + idCliente));
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(path="/{idCliente}")
	public ResponseEntity<Long> consultarPuntos(@PathVariable Long idCliente){
		Long puntos = clientesService.consultarPuntos(idCliente);
		return new ResponseEntity<>(puntos, HttpStatus.OK);
	}
	
	@PostMapping(path="/acumular")
	public void acumularPuntos(Long puntos, Long tarjeta){
		
	}
}
