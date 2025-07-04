package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
