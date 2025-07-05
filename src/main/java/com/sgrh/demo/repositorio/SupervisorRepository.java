package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
}
