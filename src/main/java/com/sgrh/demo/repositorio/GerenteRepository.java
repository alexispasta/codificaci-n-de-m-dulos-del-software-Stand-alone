package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Integer> {
}
