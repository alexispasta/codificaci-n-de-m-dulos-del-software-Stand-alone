package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.DetalleNomina;

public interface DetalleNominaRepository extends JpaRepository<DetalleNomina, Integer> {
}
