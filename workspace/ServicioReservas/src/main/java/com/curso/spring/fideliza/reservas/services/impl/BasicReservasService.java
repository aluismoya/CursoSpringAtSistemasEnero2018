package com.curso.spring.fideliza.reservas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.curso.spring.fideliza.reservas.bom.Reserva;
import com.curso.spring.fideliza.reservas.dto.ReservaDto;
import com.curso.spring.fideliza.reservas.persistencia.ReservasRepository;
import com.curso.spring.fideliza.reservas.services.IReservasService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BasicReservasService implements IReservasService {

	@Autowired
	private ReservasRepository reservasRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	/**
	 * No solo se trata de dar de alta la reserva, sino que tambien hay que acumular puntos
	 */
	
	@Override
	public Long nuevaReserva(ReservaDto reserva) {
		reservasRepository.save(objectMapper.convertValue(reserva, Reserva.class));
		
		alguien.acumularPuntos(reserva.getPuntos(), reserva.getTarjeta());
		
		return reserva.getId();
	}

	@Override
	public List<ReservaDto> consultarReservas(Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
