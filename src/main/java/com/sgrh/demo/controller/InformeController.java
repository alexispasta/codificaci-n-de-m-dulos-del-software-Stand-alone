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

import com.sgrh.demo.modelo.Informe;
import com.sgrh.demo.repositorio.InformeRepository;

@RestController
@RequestMapping("/informes")
public class InformeController {

    @Autowired
    private InformeRepository informeRepository;

    // Crear
    @PostMapping
    public Informe crearInforme(@RequestBody Informe informe) {
        return informeRepository.save(informe);
    }

    // Leer todos
    @GetMapping
    public List<Informe> listarInformes() {
        return informeRepository.findAll();
    }

    // Leer uno por ID
    @GetMapping("/{id}")
    public Informe obtenerInforme(@PathVariable Integer id) {
        return informeRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Informe actualizarInforme(@PathVariable Integer id, @RequestBody Informe informeActualizado) {
        Optional<Informe> optional = informeRepository.findById(id);

        if (optional.isPresent()) {
            Informe existente = optional.get();
            existente.setAutor(informeActualizado.getAutor());
            existente.setEmpresa(informeActualizado.getEmpresa());
            existente.setAsunto(informeActualizado.getAsunto());
            existente.setComentario(informeActualizado.getComentario());

            return informeRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarInforme(@PathVariable Integer id) {
        informeRepository.deleteById(id);
    }
}

