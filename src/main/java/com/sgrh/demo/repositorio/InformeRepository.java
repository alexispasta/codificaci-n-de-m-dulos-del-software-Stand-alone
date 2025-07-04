package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Informe;

public interface InformeRepository extends JpaRepository<Informe, Integer> {
}
