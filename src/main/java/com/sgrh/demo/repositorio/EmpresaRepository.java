// Paquete donde se encuentra la interfaz del repositorio
package com.sgrh.demo.repositorio;

// Importación de la interfaz JpaRepository de Spring Data JPA,
// que proporciona métodos CRUD y de consulta sobre entidades
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Empresa;

// Interfaz del repositorio para la entidad Empresa.
// Al extender JpaRepository, se obtienen automáticamente métodos para:
// guardar, actualizar, eliminar, buscar por ID, listar todas las empresas, etc.
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    // Si se necesitan consultas personalizadas (por nombre, ciudad, etc.),
    // pueden definirse aquí como métodos adicionales.
}
