// Paquete donde se encuentra definida esta interfaz
package com.sgrh.demo.repositorio;

// Importación de JpaRepository desde Spring Data JPA.
// Esta interfaz proporciona operaciones CRUD (crear, leer, actualizar, eliminar)
// y funcionalidades adicionales como paginación y ordenamiento.
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Permiso;

// Definición de la interfaz PermisoRepository que extiende JpaRepository.
// El primer parámetro es la entidad a gestionar (Permiso)
// y el segundo es el tipo de su clave primaria (Integer).
// Gracias a esto, Spring generará automáticamente métodos como:
// - save()
// - findById()
// - findAll()
// - deleteById(), entre otros.
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    // Aquí se pueden agregar métodos personalizados si se requieren consultas específicas
}
