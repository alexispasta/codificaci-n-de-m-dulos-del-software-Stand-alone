// Paquete base donde se encuentra esta clase controladora
package com.sgrh.demo.controller;

// Importaciones necesarias para listas y manejo de objetos opcionales
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

// Anotación que define esta clase como un controlador REST
@RestController
// Ruta base para todas las solicitudes HTTP relacionadas con permisos
@RequestMapping("/permisos")
public class PermisoController {

    // Inyección automática del repositorio de permisos
    @Autowired
    private PermisoRepository permisoRepository;

    // Método para crear un nuevo permiso (operación HTTP POST)
    @PostMapping
    public Permiso crearPermiso(@RequestBody Permiso permiso) {
        // Guarda el permiso recibido en la base de datos y lo retorna
        return permisoRepository.save(permiso);
    }

    // Método para obtener todos los permisos (operación HTTP GET)
    @GetMapping
    public List<Permiso> listarPermisos() {
        // Retorna una lista con todos los permisos almacenados
        return permisoRepository.findAll();
    }

    // Método para obtener un permiso específico por su ID (operación HTTP GET con parámetro)
    @GetMapping("/{id}")
    public Permiso obtenerPermiso(@PathVariable Integer id) {
        // Busca y retorna el permiso por ID o null si no existe
        return permisoRepository.findById(id).orElse(null);
    }

    // Método para actualizar un permiso existente (operación HTTP PUT)
    @PutMapping("/{id}")
    public Permiso actualizarPermiso(@PathVariable Integer id, @RequestBody Permiso permisoActualizado) {
        // Busca el permiso por su ID usando Optional
        Optional<Permiso> optional = permisoRepository.findById(id);

        // Si se encuentra el permiso, se actualizan sus atributos
        if (optional.isPresent()) {
            Permiso existente = optional.get();

            // Actualiza el autor del permiso
            existente.setAutor(permisoActualizado.getAutor());
            // Actualiza la persona relacionada al permiso
            existente.setPersona(permisoActualizado.getPersona());
            // Actualiza el nombre de la persona
            existente.setNombrePersona(permisoActualizado.getNombrePersona());
            // Actualiza el documento de identidad de la persona
            existente.setDocumentoIdentidad(permisoActualizado.getDocumentoIdentidad());
            // Actualiza la razón del permiso
            existente.setRazon(permisoActualizado.getRazon());
            // Actualiza la fecha de solicitud del permiso
            existente.setFechaSolicitud(permisoActualizado.getFechaSolicitud());
            // Actualiza la fecha de aplicación del permiso
            existente.setFechaAplicacion(permisoActualizado.getFechaAplicacion());

            // Guarda y retorna el permiso actualizado
            return permisoRepository.save(existente);
        } else {
            // Si no se encuentra el permiso, retorna null
            return null;
        }
    }

    // Método para eliminar un permiso por su ID (operación HTTP DELETE)
    @DeleteMapping("/{id}")
    public void eliminarPermiso(@PathVariable Integer id) {
        // Elimina el permiso correspondiente al ID proporcionado
        permisoRepository.deleteById(id);
    }
}
