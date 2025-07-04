// Paquete donde se encuentra esta interfaz del repositorio
package com.sgrh.demo.repositorio;

// Importa la interfaz JpaRepository de Spring Data JPA
// Esta proporciona todos los métodos básicos para acceder y manipular datos en la base de datos
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Persona;

// Define la interfaz PersonaRepository que extiende JpaRepository.
// Al extender JpaRepository<Persona, Integer>:
// - El primer parámetro es la entidad (Persona)
// - El segundo parámetro es el tipo de la clave primaria (Integer)
// Spring se encarga automáticamente de implementar esta interfaz con métodos CRUD básicos,
// como save(), findById(), findAll(), deleteById(), entre otros.
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    // Aquí se pueden agregar métodos personalizados si se necesitan consultas específicas más adelante
}
