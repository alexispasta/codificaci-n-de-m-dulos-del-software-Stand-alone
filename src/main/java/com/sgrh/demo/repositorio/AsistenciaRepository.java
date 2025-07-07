// Paquete donde se encuentra esta interfaz
package com.sgrh.demo.repositorio;

// Importación de la entidad Asistencia (la tabla que se manejará)
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrh.demo.modelo.Asistencia;

// Esta interfaz extiende JpaRepository, lo que le da acceso a todos los métodos de base de datos
// como save(), findById(), findAll(), deleteById(), etc., para la entidad Asistencia
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    // Consulta personalizada para obtener asistencias por fecha
    List<Asistencia> findByFecha(Date fecha);
}
