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

import com.sgrh.demo.modelo.Permiso;
import com.sgrh.demo.repositorio.PermisoRepository;

@RestController
@RequestMapping("/permisos")
public class PermisoController {

    @Autowired
    private PermisoRepository permisoRepository;

    // Crear
    @PostMapping
    public Permiso crearPermiso(@RequestBody Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    // Leer todos
    @GetMapping
    public List<Permiso> listarPermisos() {
        return permisoRepository.findAll();
    }

    // Leer uno por ID
    @GetMapping("/{id}")
    public Permiso obtenerPermiso(@PathVariable Integer id) {
        return permisoRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Permiso actualizarPermiso(@PathVariable Integer id, @RequestBody Permiso permisoActualizado) {
        Optional<Permiso> optional = permisoRepository.findById(id);

        if (optional.isPresent()) {
            Permiso existente = optional.get();

            existente.setAutor(permisoActualizado.getAutor());
            existente.setPersona(permisoActualizado.getPersona());
            existente.setNombrePersona(permisoActualizado.getNombrePersona());
            existente.setDocumentoIdentidad(permisoActualizado.getDocumentoIdentidad());
            existente.setRazon(permisoActualizado.getRazon());
            existente.setFechaSolicitud(permisoActualizado.getFechaSolicitud());
            existente.setFechaAplicacion(permisoActualizado.getFechaAplicacion());

            return permisoRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarPermiso(@PathVariable Integer id) {
        permisoRepository.deleteById(id);
    }
}
