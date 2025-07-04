// Paquete base donde se encuentra esta clase controladora
package com.sgrh.demo.controller;

// Importaciones necesarias para listas y manejo de Optional
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

// Esta clase es un controlador REST que maneja peticiones HTTP relacionadas con nóminas
@RestController
// Ruta base para acceder a los métodos de este controlador
@RequestMapping("/nominas")
// Ignora propiedades internas de Hibernate al convertir objetos a JSON
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NominaController {

    // Inyección automática del repositorio de nóminas
    @Autowired
    private NominaRepository nominaRepository;

    // Método para crear una nueva nómina (operación POST)
    @PostMapping
    public Nomina crearNomina(@RequestBody Nomina nomina) {
        // Guarda el objeto nómina recibido y lo retorna
        return nominaRepository.save(nomina);
    }

    // Método para obtener todas las nóminas (operación GET)
    @GetMapping
    public List<Nomina> listarNominas() {
        // Retorna una lista con todas las nóminas almacenadas
        return nominaRepository.findAll();
    }

    // Método para obtener una nómina por ID (operación GET con parámetro)
    @GetMapping("/{id}")
    public Nomina obtenerNomina(@PathVariable Integer id) {
        // Busca la nómina por ID y la retorna si existe, de lo contrario retorna null
        return nominaRepository.findById(id).orElse(null);
    }

    // Método para actualizar una nómina existente (operación PUT)
    @PutMapping("/{id}")
    public Nomina actualizarNomina(@PathVariable Integer id, @RequestBody Nomina nominaActualizada) {
        // Busca la nómina por su ID usando Optional
        Optional<Nomina> optional = nominaRepository.findById(id);

        // Si la nómina existe, se actualiza con los nuevos datos
        if (optional.isPresent()) {
            Nomina existente = optional.get();
            existente.setPersona(nominaActualizada.getPersona());         // Actualiza persona relacionada
            existente.setFechaPago(nominaActualizada.getFechaPago());     // Actualiza fecha de pago
            existente.setCantidad(nominaActualizada.getCantidad());       // Actualiza el valor de la nómina

            // Guarda y retorna la nómina actualizada
            return nominaRepository.save(existente);
        } else {
            // Si no se encuentra, retorna null
            return null;
        }
    }

    // Método para eliminar una nómina por su ID (operación DELETE)
    @DeleteMapping("/{id}")
    public void eliminarNomina(@PathVariable Integer id) {
        // Elimina la nómina correspondiente al ID recibido
        nominaRepository.deleteById(id);
    }
}
