package com.sgrh.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sgrh.demo.modelo.Asistencia;
import com.sgrh.demo.repositorio.AsistenciaRepository;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @PostMapping
    public Asistencia crearAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @GetMapping
    public List<Asistencia> listarAsistencias() {
        return asistenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Asistencia obtenerAsistencia(@PathVariable Integer id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    // 🔹 NUEVO: Obtener asistencias por fecha
    @GetMapping("/fecha/{fecha}")
    public List<Asistencia> obtenerPorFecha(@PathVariable String fecha) {
        try {
            Date fechaConvertida = Date.valueOf(fecha); // formato yyyy-MM-dd
            return asistenciaRepository.findByFecha(fechaConvertida);
        } catch (IllegalArgumentException e) {
            return List.of(); // Lista vacía si la fecha es inválida
        }
    }

    @PutMapping("/{id}")
    public Asistencia actualizarAsistencia(@PathVariable Integer id, @RequestBody Asistencia asistenciaActualizada) {
        Optional<Asistencia> optional = asistenciaRepository.findById(id);

        if (optional.isPresent()) {
            Asistencia existente = optional.get();
            existente.setPersona(asistenciaActualizada.getPersona());
            existente.setFecha(asistenciaActualizada.getFecha());
            existente.setEstado(asistenciaActualizada.getEstado());
            return asistenciaRepository.save(existente);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarAsistencia(@PathVariable Integer id) {
        asistenciaRepository.deleteById(id);
    }
}
