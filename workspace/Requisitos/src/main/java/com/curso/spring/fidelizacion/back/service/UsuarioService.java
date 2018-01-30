package com.curso.spring.fidelizacion.back.service;

import java.util.List;

import com.curso.spring.fidelizacion.dto.UsuarioDto;

public interface UsuarioService {

	void altaUsuario(UsuarioDto usuario);
	
	UsuarioDto busquedaDeUsuariosPorLoginYPassword(String login, String password);
	
	List<UsuarioDto> listadoDeUsuarios();
	
}
