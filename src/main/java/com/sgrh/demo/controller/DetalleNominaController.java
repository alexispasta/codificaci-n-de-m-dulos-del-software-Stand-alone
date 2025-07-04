// Paquete base donde se encuentra la clase
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

import com.sgrh.demo.modelo.DetalleNomina;
import com.sgrh.demo.repositorio.DetalleNominaRepository;

// Anotación que indica que esta clase es un controlador REST
@RestController
// Ruta base para todas las solicitudes HTTP relacionadas con DetalleNomina
@RequestMapping("/detalles-nomina")
public class DetalleNominaController {

    // Inyección automática del repositorio de detalle de nómina
    @Autowired
    private DetalleNominaRepository detalleNominaRepository;

    // Método para crear un nuevo detalle de nómina (operación POST)
    @PostMapping
    public DetalleNomina crear(@RequestBody DetalleNomina detalle) {
        // Guarda el detalle de nómina en la base de datos y lo retorna
        return detalleNominaRepository.save(detalle);
    }

    // Método para obtener todos los registros de detalle de nómina (operación GET)
    @GetMapping
    public List<DetalleNomina> obtenerTodos() {
        // Retorna una lista con todos los detalles de nómina almacenados
        return detalleNominaRepository.findAll();
    }

    // Método para obtener un detalle de nómina por su ID (operación GET)
    @GetMapping("/{id}")
    public DetalleNomina obtenerPorId(@PathVariable Integer id) {
        // Busca y retorna el detalle de nómina si existe, o null si no se encuentra
        return detalleNominaRepository.findById(id).orElse(null);
    }

    // Método para actualizar un detalle de nómina existente (operación PUT)
    @PutMapping("/{id}")
    public DetalleNomina actualizar(@PathVariable Integer id, @RequestBody DetalleNomina detalleActualizado) {
        // Verifica si el registro con el ID dado existe
        Optional<DetalleNomina> optional = detalleNominaRepository.findById(id);
        if (optional.isPresent()) {
            // Asigna el ID al objeto actualizado y lo guarda
            detalleActualizado.setId(id);
            return detalleNominaRepository.save(detalleActualizado);
        } else {
            // Si no existe, retorna null
            return null;
        }
    }

    // Método para eliminar un detalle de nómina por su ID (operación DELETE)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        // Elimina el detalle de nómina correspondiente al ID especificado
        detalleNominaRepository.deleteById(id);
    }
}
