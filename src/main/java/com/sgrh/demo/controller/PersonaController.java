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

import com.sgrh.demo.modelo.Persona;
import com.sgrh.demo.repositorio.PersonaRepository;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    // Crear
    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        try {
            return personaRepository.save(persona);
        } catch (Exception e) {
            System.err.println("Error al crear persona: " + e.getMessage());
            return null;
        }
    }

    // Leer todos
    @GetMapping
    public List<Persona> obtenerPersonas() {
        try {
            return personaRepository.findAll();
        } catch (Exception e) {
            System.err.println("Error al obtener personas: " + e.getMessage());
            return null;
        }
    }

    // Leer por ID
    @GetMapping("/{id}")
    public Persona obtenerPersona(@PathVariable Integer id) {
        try {
            return personaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.err.println("Error al obtener persona por ID: " + e.getMessage());
            return null;
        }
    }

    // Actualizar
    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Integer id, @RequestBody Persona personaActualizada) {
        try {
            Optional<Persona> optional = personaRepository.findById(id);
            if (optional.isPresent()) {
                Persona existente = optional.get();
                existente.setNombre(personaActualizada.getNombre());
                existente.setApellido(personaActualizada.getApellido());
                existente.setCorreo(personaActualizada.getCorreo());
                existente.setTelefono(personaActualizada.getTelefono());
                existente.setDireccion(personaActualizada.getDireccion());
                existente.setDocumentoIdentidad(personaActualizada.getDocumentoIdentidad());
                existente.setFechaNacimiento(personaActualizada.getFechaNacimiento());
                existente.setFechaContratacion(personaActualizada.getFechaContratacion());
                existente.setTipoContrato(personaActualizada.getTipoContrato());
                existente.setRol(personaActualizada.getRol());
                existente.setActivo(personaActualizada.getActivo());
                existente.setContrasena(personaActualizada.getContrasena());
                existente.setEmpresa(personaActualizada.getEmpresa());
                return personaRepository.save(existente);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar persona: " + e.getMessage());
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Integer id) {
        try {
            personaRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar persona: " + e.getMessage());
        }
    }
}
