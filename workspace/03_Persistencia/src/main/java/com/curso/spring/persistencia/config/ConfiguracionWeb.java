package com.curso.spring.persistencia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.curso.spring.persistencia.controllers")
@EnableWebMvc
public class ConfiguracionWeb {

}
