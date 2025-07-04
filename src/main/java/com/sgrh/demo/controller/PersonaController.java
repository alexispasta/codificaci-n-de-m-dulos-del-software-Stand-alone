// Paquete al que pertenece esta clase
package com.sgrh.demo.controller;

// Importaciones necesarias
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

// Controlador REST para gestionar entidades Persona
@RestController
@RequestMapping("/personas") // Ruta base para todas las peticiones de este controlador
public class PersonaController {

    // Inyección del repositorio de Persona para operaciones CRUD
    @Autowired
    private PersonaRepository personaRepository;

    // Método para crear una nueva Persona
    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        try {
            // Guarda la nueva persona en la base de datos
            return personaRepository.save(persona);
        } catch (Exception e) {
            // En caso de error, muestra mensaje en consola y devuelve null
            System.err.println("Error al crear persona: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener la lista de todas las personas
    @GetMapping
    public List<Persona> obtenerPersonas() {
        try {
            // Retorna todas las personas desde la base de datos
            return personaRepository.findAll();
        } catch (Exception e) {
            // En caso de error, muestra mensaje y retorna null
            System.err.println("Error al obtener personas: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener una persona específica por su ID
    @GetMapping("/{id}")
    public Persona obtenerPersona(@PathVariable Integer id) {
        try {
            // Busca la persona por ID o retorna null si no existe
            return personaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            // Manejo de errores
            System.err.println("Error al obtener persona por ID: " + e.getMessage());
            return null;
        }
    }

    // Método para actualizar una persona existente
    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Integer id, @RequestBody Persona personaActualizada) {
        try {
            // Busca la persona por ID
            Optional<Persona> optional = personaRepository.findById(id);
            if (optional.isPresent()) {
                // Si existe, actualiza los campos
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
                // Guarda los cambios y retorna el objeto actualizado
                return personaRepository.save(existente);
            } else {
                // Si no se encuentra, retorna null
                return null;
            }
        } catch (Exception e) {
            // En caso de error, muestra mensaje y retorna null
            System.err.println("Error al actualizar persona: " + e.getMessage());
            return null;
        }
    }

    // Método para eliminar una persona por ID
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Integer id) {
        try {
            // Elimina la persona con el ID especificado
            personaRepository.deleteById(id);
        } catch (Exception e) {
            // En caso de error, muestra mensaje
            System.err.println("Error al eliminar persona: " + e.getMessage());
        }
    }
}
