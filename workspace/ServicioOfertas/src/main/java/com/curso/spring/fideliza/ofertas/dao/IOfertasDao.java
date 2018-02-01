package com.curso.spring.fideliza.ofertas.dao;

import java.util.Date;
import java.util.List;

import com.curso.spring.fideliza.ofertas.bom.Oferta;

public interface IOfertasDao {
	public List<Oferta> obtenerTodasOfertas();
	public List<Oferta> obtenerOfertasMes(Date fecha);
}
