package com.curso.spring.fideliza.ofertas.bom;

import java.util.Date;

public class Oferta {
	private String id;
	private String descripcion;
	private String caducidad;
	private String puntos;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}
	
	public String getPuntos() {
		return puntos;
	}
	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}
	public Oferta(String descripcion, String caducidad) {
		super();
		this.descripcion = descripcion;
		this.caducidad = caducidad;
	}
	public Oferta() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
