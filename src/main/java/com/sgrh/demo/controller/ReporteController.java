package com.sgrh.demo.controller;

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

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteRepository reporteRepository;

    // Crear
    @PostMapping
    public Reporte crearReporte(@RequestBody Reporte reporte) {
        try {
            return reporteRepository.save(reporte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Leer todos
    @GetMapping
    public List<Reporte> listarReportes() {
        try {
            return reporteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); // Retorna lista vacía si falla
        }
    }

    // Leer por ID
    @GetMapping("/{id}")
    public Reporte obtenerReporte(@PathVariable Integer id) {
        try {
            return reporteRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Actualizar
    @PutMapping("/{id}")
    public Reporte actualizarReporte(@PathVariable Integer id, @RequestBody Reporte reporteActualizado) {
        try {
            Optional<Reporte> optional = reporteRepository.findById(id);

            if (optional.isPresent()) {
                Reporte existente = optional.get();

                existente.setAutor(reporteActualizado.getAutor());
                existente.setPersona(reporteActualizado.getPersona());
                existente.setNombrePersona(reporteActualizado.getNombrePersona());
                existente.setRazon(reporteActualizado.getRazon());
                existente.setFechaReporte(reporteActualizado.getFechaReporte());
                existente.setComentarios(reporteActualizado.getComentarios());

                return reporteRepository.save(existente);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarReporte(@PathVariable Integer id) {
        try {
            reporteRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
