package com.curso.spring.fidelizacion.back.service;

import java.util.List;

import com.curso.spring.fidelizacion.back.bussines.NegocioUsuario;
import com.curso.spring.fidelizacion.back.entities.Usuario;
import com.curso.spring.fidelizacion.back.persist.UsuarioDao;
import com.curso.spring.fidelizacion.dto.UsuarioDto;

public class CapasUsuarioService implements UsuarioService {

	private NegocioUsuario negocio;
	
	private UsuarioDao persistencia;
	
	public void setNegocio(NegocioUsuario negocio) {
		this.negocio = negocio;
	}

	public void setPersistencia(UsuarioDao persistencia) {
		this.persistencia = persistencia;
	}

	public void altaUsuario(UsuarioDto usuarioDto) {
		Usuario usuarioEntidad = negocio.dtoToEntidad(usuarioDto);
		
		persistencia.save(usuarioEntidad);
		
	}

	public UsuarioDto busquedaDeUsuariosPorLoginYPassword(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsuarioDto> listadoDeUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
