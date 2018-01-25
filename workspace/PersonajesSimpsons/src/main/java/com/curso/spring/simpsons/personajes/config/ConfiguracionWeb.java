package com.curso.spring.simpsons.personajes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.curso.spring.simpsons.personajes.controllers")
public class ConfiguracionWeb implements WebMvcConfigurer {

}
