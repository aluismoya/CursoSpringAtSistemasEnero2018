package com.curso.spring.fideliza.reservas.services;

import java.util.List;

import com.curso.spring.fideliza.reservas.dto.ReservaDto;

public interface IReservasService {

	Long nuevaReserva(ReservaDto reserva);
	
	List<ReservaDto> consultarReservas(Long idCliente);
	
}
