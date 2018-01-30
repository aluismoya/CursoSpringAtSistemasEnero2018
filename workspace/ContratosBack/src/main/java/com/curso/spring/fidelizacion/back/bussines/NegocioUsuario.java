package com.curso.spring.fidelizacion.back.bussines;

import com.curso.spring.fidelizacion.back.entities.Usuario;
import com.curso.spring.fidelizacion.dto.UsuarioDto;

public interface NegocioUsuario {

	Usuario dtoToEntidad(UsuarioDto usuarioDto);

}
