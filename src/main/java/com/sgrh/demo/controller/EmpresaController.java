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

import com.sgrh.demo.modelo.Empresa;
import com.sgrh.demo.repositorio.EmpresaRepository;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Crear
    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // Leer todos
    @GetMapping
    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.findAll();
    }

    // Leer por ID
    @GetMapping("/{id}")
    public Empresa obtenerEmpresa(@PathVariable Integer id) {
        return empresaRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Empresa actualizarEmpresa(@PathVariable Integer id, @RequestBody Empresa empresaActualizada) {
        Optional<Empresa> optional = empresaRepository.findById(id);

        if (optional.isPresent()) {
            Empresa existente = optional.get();
            existente.setNombre(empresaActualizada.getNombre());
            existente.setTelefono(empresaActualizada.getTelefono());
            existente.setDireccion(empresaActualizada.getDireccion());
            existente.setCiudad(empresaActualizada.getCiudad());
            existente.setPais(empresaActualizada.getPais());
            return empresaRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable Integer id) {
        empresaRepository.deleteById(id);
    }
}
