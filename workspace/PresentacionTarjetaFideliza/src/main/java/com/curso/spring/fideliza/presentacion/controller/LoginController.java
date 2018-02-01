package com.curso.spring.fideliza.presentacion.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curso.spring.fideliza.presentacion.dto.Cliente;
import com.curso.spring.fideliza.presentacion.dto.Operador;
import com.curso.spring.fideliza.presentacion.dto.Usuario;
import com.curso.spring.fideliza.presentacion.services.ILoginService;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;

	
	@ModelAttribute("cliente")
	public Cliente cliente() {
		return new Cliente();
	}
	
	@ModelAttribute("operador")
	public Operador operador() {
		return new Operador();
	}
	
	@RequestMapping(path="/login", method = RequestMethod.GET)
	public String iniciarFormulario(Map<String,Object> model) {
		return "login";
	}
	
	
	@RequestMapping(path="/inicio", method = RequestMethod.POST)
	public String procesarFormulario(@ModelAttribute Usuario usuario, HttpSession session) {
		String returnView = "login";
		
		Usuario user = new Usuario(usuario.getUsuario(), usuario.getPassword(), usuario.getEmail());
		user = loginService.login(user);
		if(user!=null) {
			if(user.getTipo()!=null&&user.getTipo().equals("cliente")) {//devolvemos vista de cliente
				returnView = "inicio";
			}else {
				returnView = "inicioOperador";
			}
			
			usuario.setUsuario(user.getUsuario());
			usuario.setId(user.getId());
			usuario.setTipo(user.getTipo());
			usuario.setPassword("");
			session.setAttribute("usuario", usuario);
		}
		return returnView;
	}
	
	
	@RequestMapping(path="/registro", method = RequestMethod.GET)
	public String iniciarRegistro(Map<String,Object> model) {
		return "registro";
	}
	
	@RequestMapping(path="/registroCliente", method = RequestMethod.GET)
	public String registroCliente(Map<String,Object> model) {
		return "registroCliente";
	}
	
	@RequestMapping(path="/registroCliente", method = RequestMethod.POST)
	public String registroCliente(@ModelAttribute Cliente cliente, HttpSession session) {
		String returnView = "login";
		
		Usuario user = new Usuario(cliente.getDatosUsuario().getUsuario(), cliente.getDatosUsuario().getPassword(), cliente.getDatosUsuario().getEmail(), "cliente");
		user = loginService.register(user);
		if(user!=null) {
			Cliente clienteEntity = new Cliente();
			loginService.registrarCliente(clienteEntity);
			cliente.getDatosUsuario().setTipo("cliente");
			session.setAttribute("usuario", cliente.getDatosUsuario());
			returnView = "inicio";
		}
		return returnView;
	}
	
	@RequestMapping(path="/registroOperador", method = RequestMethod.GET)
	public String registroOperador(Map<String,Object> model) {
		return "registroOperador";
	}
	
	@RequestMapping(path="/logout", method = RequestMethod.GET)
	public String logout(Map<String,Object> model, HttpSession sesion) {
		sesion.removeAttribute("usuario");
		return "login";
	}
}
