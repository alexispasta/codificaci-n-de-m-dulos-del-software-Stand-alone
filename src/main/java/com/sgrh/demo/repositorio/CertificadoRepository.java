package com.sgrh.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Certificado;

public interface CertificadoRepository extends JpaRepository<Certificado, Integer> {
}
