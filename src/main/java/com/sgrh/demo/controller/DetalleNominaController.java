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

import com.sgrh.demo.modelo.DetalleNomina;
import com.sgrh.demo.repositorio.DetalleNominaRepository;

@RestController
@RequestMapping("/detalles-nomina")
public class DetalleNominaController {

    @Autowired
    private DetalleNominaRepository detalleNominaRepository;

    // Crear
    @PostMapping
    public DetalleNomina crear(@RequestBody DetalleNomina detalle) {
        return detalleNominaRepository.save(detalle);
    }

    // Leer todos
    @GetMapping
    public List<DetalleNomina> obtenerTodos() {
        return detalleNominaRepository.findAll();
    }

    // Leer por ID
    @GetMapping("/{id}")
    public DetalleNomina obtenerPorId(@PathVariable Integer id) {
        return detalleNominaRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public DetalleNomina actualizar(@PathVariable Integer id, @RequestBody DetalleNomina detalleActualizado) {
        Optional<DetalleNomina> optional = detalleNominaRepository.findById(id);
        if (optional.isPresent()) {
            detalleActualizado.setId(id);
            return detalleNominaRepository.save(detalleActualizado);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleNominaRepository.deleteById(id);
    }
}
