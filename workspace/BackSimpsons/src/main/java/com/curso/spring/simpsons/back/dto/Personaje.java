package com.curso.spring.simpsons.back.dto;

public class Personaje {

	private String id; //PK
	private String idPadre; //FK contra Personajes
	private String nombre;
	private String apellido;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(String idPadre) {
		this.idPadre = idPadre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Personaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personaje(String id, String idPadre, String nombre, String apellido) {
		super();
		this.id = id;
		this.idPadre = idPadre;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Personaje [id=" + id + ", idPadre=" + idPadre + ", apellido=" + apellido + "]";
	}	
}
