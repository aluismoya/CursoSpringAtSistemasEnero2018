package com.ejemplo.arquitectura.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HolaMundoController {

	@Value("${message:Hello default}")
    private String message;
	
	@RequestMapping("/")
	public String home() {
		return message;
		//Para provocar el comportamiento e Circuit Breaker
		//throw new RuntimeException();


	}
}