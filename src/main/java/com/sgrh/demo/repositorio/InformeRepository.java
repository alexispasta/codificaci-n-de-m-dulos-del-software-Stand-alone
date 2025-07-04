// Paquete donde se encuentra esta interfaz del repositorio
package com.sgrh.demo.repositorio;

// Importación de JpaRepository de Spring Data JPA,
// que provee métodos CRUD y de consulta para entidades
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Informe;

// Interfaz del repositorio para la entidad Informe.
// Al extender JpaRepository, se heredan funcionalidades como:
// - guardar un informe (save)
// - buscar por ID (findById)
// - listar todos los informes (findAll)
// - eliminar por ID (deleteById)
// entre otras, sin necesidad de escribir código adicional.
public interface InformeRepository extends JpaRepository<Informe, Integer> {
    // Aquí se pueden declarar métodos personalizados si se necesitan consultas específicas
}
