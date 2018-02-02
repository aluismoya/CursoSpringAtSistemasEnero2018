package com.curso.spring.fideliza.login.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.spring.fideliza.login.dto.LoginDto;
import com.curso.spring.fideliza.login.services.ILoginService;

public class LoginRestService {

	@Autowired
	private ILoginService loginService;
	
	@PostMapping(path="/")
	public ResponseEntity<LoginDto> login(@RequestParam String user, @RequestParam String password){
		LoginDto login = loginService.login(user, password);
		return new ResponseEntity<LoginDto>(login, HttpStatus.OK);
	}
	
}
