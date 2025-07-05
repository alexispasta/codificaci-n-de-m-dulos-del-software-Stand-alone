package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
