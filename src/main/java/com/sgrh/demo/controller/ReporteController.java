// Paquete del proyecto donde se encuentra el controlador
package com.sgrh.demo.controller;

// Importaciones necesarias para el funcionamiento del controlador
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgrh.demo.modelo.Reporte;
import com.sgrh.demo.repositorio.ReporteRepository;

// Esta clase es un controlador REST para la entidad Reporte
@RestController
@RequestMapping("/reportes") // Define la URL base para este controlador
public class ReporteController {

    // Inyección del repositorio que maneja operaciones CRUD para Reporte
    @Autowired
    private ReporteRepository reporteRepository;

    // Método para crear un nuevo reporte
    @PostMapping
    public Reporte crearReporte(@RequestBody Reporte reporte) {
        try {
            // Guarda el nuevo reporte en la base de datos
            return reporteRepository.save(reporte);
        } catch (Exception e) {
            // Imprime error si ocurre una excepción
            e.printStackTrace();
            return null;
        }
    }

    // Método para listar todos los reportes
    @GetMapping
    public List<Reporte> listarReportes() {
        try {
            // Retorna todos los registros de la tabla Reporte
            return reporteRepository.findAll();
        } catch (Exception e) {
            // En caso de error, imprime el error y retorna una lista vacía
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // Método para obtener un reporte por su ID
    @GetMapping("/{id}")
    public Reporte obtenerReporte(@PathVariable Integer id) {
        try {
            // Busca y retorna el reporte correspondiente al ID, o null si no lo encuentra
            return reporteRepository.findById(id).orElse(null);
        } catch (Exception e) {
            // Muestra el error en consola y retorna null
            e.printStackTrace();
            return null;
        }
    }

    // Método para actualizar un reporte existente
    @PutMapping("/{id}")
    public Reporte actualizarReporte(@PathVariable Integer id, @RequestBody Reporte reporteActualizado) {
        try {
            // Busca el reporte por ID
            Optional<Reporte> optional = reporteRepository.findById(id);

            if (optional.isPresent()) {
                // Si el reporte existe, se actualizan sus campos
                Reporte existente = optional.get();
                existente.setAutor(reporteActualizado.getAutor());
                existente.setPersona(reporteActualizado.getPersona());
                existente.setNombrePersona(reporteActualizado.getNombrePersona());
                existente.setRazon(reporteActualizado.getRazon());
                existente.setFechaReporte(reporteActualizado.getFechaReporte());
                existente.setComentarios(reporteActualizado.getComentarios());

                // Se guarda y retorna el reporte actualizado
                return reporteRepository.save(existente);
            } else {
                // Si no se encuentra el reporte, se retorna null
                return null;
            }
        } catch (Exception e) {
            // En caso de error, imprimirlo y retornar null
            e.printStackTrace();
            return null;
        }
    }

    // Método para eliminar un reporte por ID
    @DeleteMapping("/{id}")
    public void eliminarReporte(@PathVariable Integer id) {
        try {
            // Elimina el reporte con el ID especificado
            reporteRepository.deleteById(id);
        } catch (Exception e) {
            // Imprime el error si ocurre
            e.printStackTrace();
        }
    }
}
