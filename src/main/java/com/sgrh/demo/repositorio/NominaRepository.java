package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Nomina;

public interface NominaRepository extends JpaRepository<Nomina, Integer> {
}
