package com.curso.spring.fideliza.presentacion.services;

import com.curso.spring.fideliza.presentacion.dto.Cliente;
import com.curso.spring.fideliza.presentacion.dto.Operador;
import com.curso.spring.fideliza.presentacion.dto.Usuario;

public interface ILoginService {

	public Usuario login(Usuario usuario);
	public Usuario logout(Usuario usuario);
	public Usuario register(Usuario usuario);
	public Cliente registrarCliente(Cliente cliente);
	public Operador registrarOperador(Operador operador);
	
}
