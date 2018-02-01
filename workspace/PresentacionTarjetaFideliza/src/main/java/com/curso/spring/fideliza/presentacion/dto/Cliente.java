package com.curso.spring.fideliza.presentacion.dto;

public class Cliente {

	Usuario datosUsuario;
	String puntos;
	public Usuario getDatosUsuario() {
		return datosUsuario;
	}
	public void setDatosUsuario(Usuario datosUsuario) {
		this.datosUsuario = datosUsuario;
	}
	public String getPuntos() {
		return puntos;
	}
	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}
	public Cliente(Usuario datosUsuario, String puntos) {
		super();
		this.datosUsuario = datosUsuario;
		this.puntos = puntos;
	}
	public Cliente() {
		super();
	}
	
	
}
