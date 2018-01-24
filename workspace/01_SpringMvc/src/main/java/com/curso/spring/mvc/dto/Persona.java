package com.curso.spring.mvc.dto;

public class Persona {

	private int id;
	private String nombre;
	private Genero sexo;
	public Genero getSexo() {
		return sexo;
	}
	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Persona(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
