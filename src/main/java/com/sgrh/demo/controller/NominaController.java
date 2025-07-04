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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sgrh.demo.modelo.Nomina;
import com.sgrh.demo.repositorio.NominaRepository;

@RestController
@RequestMapping("/nominas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class NominaController {

    @Autowired
    private NominaRepository nominaRepository;

    // Crear
    @PostMapping
    public Nomina crearNomina(@RequestBody Nomina nomina) {
        return nominaRepository.save(nomina);
    }

    // Leer todos
    @GetMapping
    public List<Nomina> listarNominas() {
        return nominaRepository.findAll();
    }

    // Leer uno
    @GetMapping("/{id}")
    public Nomina obtenerNomina(@PathVariable Integer id) {
        return nominaRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Nomina actualizarNomina(@PathVariable Integer id, @RequestBody Nomina nominaActualizada) {
        Optional<Nomina> optional = nominaRepository.findById(id);

        if (optional.isPresent()) {
            Nomina existente = optional.get();
            existente.setPersona(nominaActualizada.getPersona());
            existente.setFechaPago(nominaActualizada.getFechaPago());
            existente.setCantidad(nominaActualizada.getCantidad());

            return nominaRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarNomina(@PathVariable Integer id) {
        nominaRepository.deleteById(id);
    }
}
