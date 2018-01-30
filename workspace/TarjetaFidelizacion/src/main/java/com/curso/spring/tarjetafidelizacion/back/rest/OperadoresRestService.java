package com.curso.spring.tarjetafidelizacion.back.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimientoPuntos")
public class OperadoresRestService {

	@Autowired
	private MovimientosService movimientosService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> acumularPuntos(@RequestBody MovimientoPuntos movimiento){
		return null;
	}
	
}
