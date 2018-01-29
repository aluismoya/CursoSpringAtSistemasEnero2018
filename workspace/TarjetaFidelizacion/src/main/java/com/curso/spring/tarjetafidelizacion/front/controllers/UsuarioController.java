package com.curso.spring.tarjetafidelizacion.front.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

	//Refactorizar a ViewController
	@GetMapping("/bienvenida")
	public String bienvenida(){
		return "bienvenida";
	}
	
	//Creamos este objeto a nivel de Request, para rellenar los campos del formulario de Login
	@ModelAttribute("login")
	public Login login() {
		return new Login();
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@PostMapping("/login")
	public String procesarLogin(@ModelAttribute Login login, HttpSession session){
		
		//Si error
		//return "login";
		
		//Si exito
		Usuario usuario = null;
		session.setAttribute("usuario", usuario);
		
		return "bienvenida";
	}
	
	@GetMapping("/ofertas")
	public String ofertas(HttpSession session, Map<String, Object> model){
		
		session.getAttribute("usuario");
		
		//Trabajo previo, para recuperar las ofertas de back
		List<Oferta> ofertas = null;
		
		model.put("ofertas", ofertas);
		
		return "ofertas";
	}
	
	@GetMapping("/puntos")
	public String puntos(HttpSession session, Map<String, Object> model){
			
		session.getAttribute("usuario");
		
		//Trabajo previo, para recuperar las ofertas de back
		long puntos = 0;
		
		model.put("puntos", puntos);
		
		return "puntos";
	}
	
	@GetMapping("/reservas")
	public String reservas(HttpSession session, Map<String, Object> model){
		session.getAttribute("usuario");
		
		//Trabajo previo, para recuperar las ofertas de back
		List<Reserva> reservas = null;
		
		model.put("reservas", reservas);
		
		return "reservas";
	}
	
	@ModelAttribute("usuario")
	public Usuario usuario() {
		return new Usuario();
	}
	
	@GetMapping("/registro")
	public String registro(){
		return "registro";
	}
	
	@PostMapping("/registro")
	public String procesarRegistro(@ModelAttribute Usuario usuario, Map<String, Object> model){
		//Si error
		//return "registro";
		
		//Si exito
		return "bienvenida";
		//return "login";
	}
	
	
	
}
