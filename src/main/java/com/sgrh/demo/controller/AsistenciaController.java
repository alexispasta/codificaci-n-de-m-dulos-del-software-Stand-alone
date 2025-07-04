// Paquete base donde se encuentra esta clase
package com.sgrh.demo.controller;

// Importación del modelo Asistencia
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

import com.sgrh.demo.modelo.Asistencia;
import com.sgrh.demo.repositorio.AsistenciaRepository;

// Anotación que indica que esta clase es un controlador REST
@RestController
// Define la ruta base para las solicitudes HTTP relacionadas con asistencias
@RequestMapping("/asistencias")
public class AsistenciaController {

    // Inyección del repositorio de asistencia para realizar operaciones con la base de datos
    @Autowired
    private AsistenciaRepository asistenciaRepository;

    // Método para crear una nueva asistencia (operación POST)
    @PostMapping
    public Asistencia crearAsistencia(@RequestBody Asistencia asistencia) {
        // Guarda la asistencia recibida y la retorna
        return asistenciaRepository.save(asistencia);
    }

    // Método para obtener todas las asistencias registradas (operación GET)
    @GetMapping
    public List<Asistencia> listarAsistencias() {
        // Retorna una lista con todas las asistencias de la base de datos
        return asistenciaRepository.findAll();
    }

    // Método para obtener una asistencia específica por su ID (operación GET)
    @GetMapping("/{id}")
    public Asistencia obtenerAsistencia(@PathVariable Integer id) {
        // Busca la asistencia por ID y la retorna, o retorna null si no existe
        return asistenciaRepository.findById(id).orElse(null);
    }

    // Método para actualizar una asistencia existente (operación PUT)
    @PutMapping("/{id}")
    public Asistencia actualizarAsistencia(@PathVariable Integer id, @RequestBody Asistencia asistenciaActualizada) {
        // Busca la asistencia por ID
        Optional<Asistencia> optional = asistenciaRepository.findById(id);

        // Si se encuentra la asistencia, se actualizan los campos
        if (optional.isPresent()) {
            Asistencia existente = optional.get();

            // Se actualizan los campos del registro existente con los valores recibidos
            existente.setAutor(asistenciaActualizada.getAutor());
            existente.setPersona(asistenciaActualizada.getPersona());
            existente.setNombrePersona(asistenciaActualizada.getNombrePersona());
            existente.setDocumentoIdentidad(asistenciaActualizada.getDocumentoIdentidad());
            existente.setDiasFaltados(asistenciaActualizada.getDiasFaltados());

            // Se guarda la asistencia actualizada y se retorna
            return asistenciaRepository.save(existente);
        } else {
            // Si no se encuentra la asistencia, se retorna null
            return null;
        }
    }

    // Método para eliminar una asistencia por ID (operación DELETE)
    @DeleteMapping("/{id}")
    public void eliminarAsistencia(@PathVariable Integer id) {
        // Elimina la asistencia con el ID especificado
        asistenciaRepository.deleteById(id);
    }
}
