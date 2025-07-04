package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
