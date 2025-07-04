// Paquete en el que se encuentra esta interfaz
package com.sgrh.demo.repositorio;

// Importación del repositorio base de Spring Data JPA que proporciona operaciones CRUD
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Certificado;

// Interfaz que extiende JpaRepository para la entidad Certificado.
// Esto permite realizar operaciones básicas (CRUD) sin necesidad de implementar código adicional.
public interface CertificadoRepository extends JpaRepository<Certificado, Integer> {
    // Aquí se pueden definir métodos personalizados si se requieren búsquedas específicas,
    // pero JpaRepository ya proporciona métodos como save(), findAll(), findById(), deleteById(), etc.
}
