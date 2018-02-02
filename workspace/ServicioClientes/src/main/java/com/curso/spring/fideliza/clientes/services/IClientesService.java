package com.curso.spring.fideliza.clientes.services;

import com.curso.spring.fideliza.clientes.dto.ClienteDto;

public interface IClientesService {
	
	Long registrarCliente(ClienteDto cliente);
	
	Long consultarPuntos(Long idCliente);
	
}
