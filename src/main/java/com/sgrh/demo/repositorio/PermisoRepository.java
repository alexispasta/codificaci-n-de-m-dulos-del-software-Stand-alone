package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
}
