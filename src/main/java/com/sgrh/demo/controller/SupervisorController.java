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

import com.sgrh.demo.modelo.Supervisor;
import com.sgrh.demo.repositorio.SupervisorRepository;

@RestController
@RequestMapping("/supervisores")
public class SupervisorController {

    @Autowired
    private SupervisorRepository supervisorRepository;

    // Crear
    @PostMapping
    public Supervisor crearSupervisor(@RequestBody Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    // Leer todos
    @GetMapping
    public List<Supervisor> listarSupervisores() {
        return supervisorRepository.findAll();
    }

    // Leer uno por ID
    @GetMapping("/{id}")
    public Supervisor obtenerSupervisor(@PathVariable Integer id) {
        return supervisorRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Supervisor actualizarSupervisor(@PathVariable Integer id, @RequestBody Supervisor supervisorActualizado) {
        Optional<Supervisor> optional = supervisorRepository.findById(id);
        if (optional.isPresent()) {
            Supervisor existente = optional.get();
            existente.setPersona(supervisorActualizado.getPersona());
            existente.setFechaContratacion(supervisorActualizado.getFechaContratacion());
            return supervisorRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarSupervisor(@PathVariable Integer id) {
        supervisorRepository.deleteById(id);
    }
}
