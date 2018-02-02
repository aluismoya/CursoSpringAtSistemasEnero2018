package com.curso.spring.fideliza.reservas.services.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.fideliza.reservas.dto.ReservaDto;
import com.curso.spring.fideliza.reservas.services.IReservasService;

@RestController
public class ReservasRestService {

	@Autowired
	private IReservasService reservasService;
	
	@PostMapping(path="/", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> nuevaReserva(@RequestBody ReservaDto reserva) throws URISyntaxException{
		Long idReserva = reservasService.nuevaReserva(reserva);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(new URI("http://......" + idReserva));
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/")
	public ResponseEntity<List<ReservaDto>> consultarReservas(@RequestParam Long idCliente){
		return null;
	}
	
}
