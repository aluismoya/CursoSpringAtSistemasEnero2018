package com.curso.spring.persistencia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.curso.spring.persistencia.servicios.data.jpa")
//@ComponentScan("com.curso.spring.persistencia.servicios.simple")
public class ConfiguracionServicios {

}
