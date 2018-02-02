package com.ejemplo.arquitectura.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="holamundo")//,  configuration = Configuracion.class)
public interface ServicioHolaMundo {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String holaMundo();
}
