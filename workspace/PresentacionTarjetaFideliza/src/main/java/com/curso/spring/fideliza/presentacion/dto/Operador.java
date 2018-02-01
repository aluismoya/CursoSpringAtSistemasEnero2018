package com.curso.spring.fideliza.presentacion.dto;

public class Operador {

	private String id;
	private String id_usuario;
	private String cif;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public Operador(String id) {
		super();
		this.id = id;
	}

	public Operador() {
		super();
	}
	
	
}
