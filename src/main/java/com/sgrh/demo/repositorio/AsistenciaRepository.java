package com.sgrh.demo.repositorio;

import com.sgrh.demo.modelo.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
}
