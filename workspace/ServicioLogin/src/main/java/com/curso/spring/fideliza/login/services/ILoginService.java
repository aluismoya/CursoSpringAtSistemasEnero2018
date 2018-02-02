package com.curso.spring.fideliza.login.services;

import com.curso.spring.fideliza.login.dto.LoginDto;

public interface ILoginService {

	LoginDto login(String user, String password);
	
}
