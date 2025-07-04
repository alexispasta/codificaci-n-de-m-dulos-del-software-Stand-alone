// Paquete donde se encuentra este repositorio
package com.sgrh.demo.repositorio;

// Importación de JpaRepository, que proporciona métodos CRUD y más para la persistencia de datos
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.DetalleNomina;

// Interfaz que extiende JpaRepository para la entidad DetalleNomina.
// Esto permite acceder a todas las operaciones básicas como guardar, eliminar, actualizar,
// buscar por ID o listar todos los registros de DetalleNomina sin necesidad de implementar código adicional.
public interface DetalleNominaRepository extends JpaRepository<DetalleNomina, Integer> {
    // Aquí se pueden agregar métodos personalizados si se requieren consultas específicas
}
