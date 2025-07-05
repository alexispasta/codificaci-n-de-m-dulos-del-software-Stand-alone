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

import com.sgrh.demo.modelo.Gerente;
import com.sgrh.demo.repositorio.GerenteRepository;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    private GerenteRepository gerenteRepository;

    // Crear
    @PostMapping
    public Gerente crearGerente(@RequestBody Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    // Leer todos
    @GetMapping
    public List<Gerente> listarGerentes() {
        return gerenteRepository.findAll();
    }

    // Leer uno por ID
    @GetMapping("/{id}")
    public Gerente obtenerGerente(@PathVariable Integer id) {
        return gerenteRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Gerente actualizarGerente(@PathVariable Integer id, @RequestBody Gerente gerenteActualizado) {
        Optional<Gerente> optional = gerenteRepository.findById(id);
        if (optional.isPresent()) {
            Gerente existente = optional.get();
            existente.setPersona(gerenteActualizado.getPersona());
            existente.setFechaContratacion(gerenteActualizado.getFechaContratacion());
            return gerenteRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarGerente(@PathVariable Integer id) {
        gerenteRepository.deleteById(id);
    }
}
