package com.sgrh.demo.controller;

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

import com.sgrh.demo.modelo.Rrhh;
import com.sgrh.demo.repositorio.RrhhRepository;

@RestController
@RequestMapping("/rrhh")
public class RrhhController {

    @Autowired
    private RrhhRepository rrhhRepository;

    // Crear
    @PostMapping
    public Rrhh crearRrhh(@RequestBody Rrhh rrhh) {
        return rrhhRepository.save(rrhh);
    }

    // Leer todos
    @GetMapping
    public List<Rrhh> listarRrhh() {
        return rrhhRepository.findAll();
    }

    // Leer uno por ID
    @GetMapping("/{id}")
    public Rrhh obtenerRrhh(@PathVariable Integer id) {
        return rrhhRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Rrhh actualizarRrhh(@PathVariable Integer id, @RequestBody Rrhh rrhhActualizado) {
        Optional<Rrhh> optional = rrhhRepository.findById(id);
        if (optional.isPresent()) {
            Rrhh existente = optional.get();
            existente.setPersona(rrhhActualizado.getPersona());
            existente.setFechaContratacion(rrhhActualizado.getFechaContratacion());
            return rrhhRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarRrhh(@PathVariable Integer id) {
        rrhhRepository.deleteById(id);
    }
}
