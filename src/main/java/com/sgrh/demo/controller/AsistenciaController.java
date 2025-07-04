package com.sgrh.demo.controller;

import com.sgrh.demo.modelo.Asistencia;
import com.sgrh.demo.repositorio.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    // Crear
    @PostMapping
    public Asistencia crearAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    // Leer todos
    @GetMapping
    public List<Asistencia> listarAsistencias() {
        return asistenciaRepository.findAll();
    }

    // Leer por ID
    @GetMapping("/{id}")
    public Asistencia obtenerAsistencia(@PathVariable Integer id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Asistencia actualizarAsistencia(@PathVariable Integer id, @RequestBody Asistencia asistenciaActualizada) {
        Optional<Asistencia> optional = asistenciaRepository.findById(id);

        if (optional.isPresent()) {
            Asistencia existente = optional.get();

            existente.setAutor(asistenciaActualizada.getAutor());
            existente.setPersona(asistenciaActualizada.getPersona());
            existente.setNombrePersona(asistenciaActualizada.getNombrePersona());
            existente.setDocumentoIdentidad(asistenciaActualizada.getDocumentoIdentidad());
            existente.setDiasFaltados(asistenciaActualizada.getDiasFaltados());

            return asistenciaRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarAsistencia(@PathVariable Integer id) {
        asistenciaRepository.deleteById(id);
    }
}
