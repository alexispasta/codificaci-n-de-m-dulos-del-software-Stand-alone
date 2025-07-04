// Paquete donde se encuentra esta interfaz del repositorio
package com.sgrh.demo.repositorio;

// Importa la interfaz JpaRepository desde Spring Data JPA.
// Esta interfaz proporciona una implementación automática de operaciones CRUD
// y permite consultas personalizadas si se agregan métodos adicionales.
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Reporte;

// Define la interfaz ReporteRepository que extiende JpaRepository.
// El primer parámetro es la clase de entidad (Reporte),
// y el segundo parámetro es el tipo de dato de su clave primaria (Integer).
// Esto permite a Spring Data generar automáticamente métodos como:
// - save()
// - findById()
// - findAll()
// - deleteById()
// entre otros.
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    // Aquí puedes definir métodos personalizados para realizar consultas más específicas si los necesitas.
}
