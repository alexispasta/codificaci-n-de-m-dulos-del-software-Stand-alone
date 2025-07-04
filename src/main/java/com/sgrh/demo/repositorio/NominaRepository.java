// Paquete en el que se encuentra la interfaz del repositorio
package com.sgrh.demo.repositorio;

// Importación de la interfaz JpaRepository de Spring Data JPA,
// que proporciona métodos CRUD (crear, leer, actualizar, eliminar) y consultas avanzadas
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Nomina;

// Interfaz del repositorio para la entidad Nomina.
// Al extender JpaRepository, esta interfaz hereda métodos predefinidos para operar sobre la base de datos.
// Por ejemplo: save(), findById(), findAll(), deleteById(), etc.
public interface NominaRepository extends JpaRepository<Nomina, Integer> {
    // Se pueden declarar aquí métodos personalizados si se requieren consultas específicas
}
