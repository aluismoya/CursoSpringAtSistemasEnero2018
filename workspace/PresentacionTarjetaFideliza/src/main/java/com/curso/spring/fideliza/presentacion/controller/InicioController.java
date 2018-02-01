package com.curso.spring.fideliza.presentacion.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curso.spring.fideliza.presentacion.dto.Cliente;
import com.curso.spring.fideliza.presentacion.dto.Usuario;
import com.curso.spring.fideliza.presentacion.services.IClienteService;
import com.curso.spring.fideliza.presentacion.services.IOfertasService;

@Controller
public class InicioController {

	@Autowired
	private IOfertasService ofertasService;

	@Autowired
	private IClienteService clienteService;

	/**
	 * Consultar puntos
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/consultaPuntos", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public String consultarPuntos(HttpSession session) {
		Usuario usuario = (Usuario)session.getAttribute("usuario");
//		Usuario user = new Usuario(usuario.getId());
		Cliente cli = new Cliente();
		cli = clienteService.obtenerCliente(cli);
		return "{\"puntos\":"+cli.getPuntos()+"}";
	}
	
	@RequestMapping(path = "/ofertas/listado", method = RequestMethod.GET)
	public String listarOfertas(Model model, HttpSession sesion) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		// comprobamos que se haya logado el usuario
		if (usuario != null) {
			Cliente cliente = new Cliente();
			cliente = clienteService.obtenerCliente(cliente);
			model.addAttribute("puntos", cliente.getPuntos());
			model.addAttribute("ofertas", ofertasService.consultarTodas());
			return "ofertas";
		} else {
			return "login";
		}
		
	}

	@RequestMapping(path = "/inicio", method = RequestMethod.GET)
	public String iniciarMenu(Map<String, Object> model, HttpServletRequest request) {
		// comprobamos que se haya logado el usuario
		Usuario usuarioLogueado = (Usuario) request.getSession().getAttribute("usuario");
		if (usuarioLogueado != null) {
			return "inicio";
		} else {
			return "login";
		}

	}

}
