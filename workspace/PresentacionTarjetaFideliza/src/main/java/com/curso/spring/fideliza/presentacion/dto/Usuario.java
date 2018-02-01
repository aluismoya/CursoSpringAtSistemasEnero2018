package com.curso.spring.fideliza.presentacion.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

	private String id;
	private String usuario;
	private String password;
	private String email;
	private String tipo;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = cifrarPassowrd(password);
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario() {

	};

	public Usuario(String id) {
		super();
		this.id = id;
	}

	public Usuario(String usuario, String password, String email) {
		super();
		this.usuario = usuario;
		this.password = cifrarPassowrd(password);
		this.email = email;
	}

	public Usuario(String usuario, String password, String email, String tipo) {
		super();
		this.usuario = usuario;
		this.password = cifrarPassowrd(password);
		this.email = email;
		this.tipo = tipo;
	}

	public String cifrarPassowrd(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = password.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
