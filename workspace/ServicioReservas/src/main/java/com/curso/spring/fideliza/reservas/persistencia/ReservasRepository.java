package com.curso.spring.fideliza.reservas.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.spring.fideliza.reservas.bom.Reserva;

public interface ReservasRepository extends JpaRepository<Reserva, Long>{

}
