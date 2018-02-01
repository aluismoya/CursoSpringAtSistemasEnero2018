package com.curso.spring.fideliza.presentacion.services;

import com.curso.spring.fideliza.presentacion.dto.Cliente;
import com.curso.spring.fideliza.presentacion.dto.Usuario;

public interface IClienteService {

	public Cliente registrarCliente(Cliente cliente);
	public Cliente obtenerCliente(Cliente cliente);
	public Cliente obtenerCliente(Usuario usuario);
	
}
