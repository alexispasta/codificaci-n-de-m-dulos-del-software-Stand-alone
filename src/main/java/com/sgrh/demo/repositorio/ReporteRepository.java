package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Reporte;

public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
}

