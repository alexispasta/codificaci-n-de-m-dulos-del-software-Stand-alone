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

import com.sgrh.demo.modelo.Informe;
import com.sgrh.demo.repositorio.InformeRepository;

// Anotación que indica que esta clase es un controlador REST
@RestController
// Define la ruta base para todas las solicitudes HTTP relacionadas con informes
@RequestMapping("/informes")
public class InformeController {

    // Inyección automática del repositorio de informes
    @Autowired
    private InformeRepository informeRepository;

    // Método para crear un nuevo informe (operación POST)
    @PostMapping
    public Informe crearInforme(@RequestBody Informe informe) {
        // Guarda el informe en la base de datos y lo retorna
        return informeRepository.save(informe);
    }

    // Método para obtener todos los informes (operación GET)
    @GetMapping
    public List<Informe> listarInformes() {
        // Retorna una lista con todos los informes existentes
        return informeRepository.findAll();
    }

    // Método para obtener un informe por su ID (operación GET con parámetro)
    @GetMapping("/{id}")
    public Informe obtenerInforme(@PathVariable Integer id) {
        // Busca el informe por su ID y lo retorna si existe, o null si no se encuentra
        return informeRepository.findById(id).orElse(null);
    }

    // Método para actualizar un informe existente (operación PUT)
    @PutMapping("/{id}")
    public Informe actualizarInforme(@PathVariable Integer id, @RequestBody Informe informeActualizado) {
        // Busca el informe por su ID
        Optional<Informe> optional = informeRepository.findById(id);

        // Si el informe existe, se actualizan sus atributos
        if (optional.isPresent()) {
            Informe existente = optional.get();
            existente.setAutor(informeActualizado.getAutor());             // Actualiza el autor
            existente.setEmpresa(informeActualizado.getEmpresa());         // Actualiza la empresa
            existente.setAsunto(informeActualizado.getAsunto());           // Actualiza el asunto
            existente.setComentario(informeActualizado.getComentario());   // Actualiza el comentario

            // Guarda y retorna el informe actualizado
            return informeRepository.save(existente);
        } else {
            // Si no existe, retorna null
            return null;
        }
    }

    // Método para eliminar un informe por su ID (operación DELETE)
    @DeleteMapping("/{id}")
    public void eliminarInforme(@PathVariable Integer id) {
        // Elimina el informe correspondiente al ID proporcionado
        informeRepository.deleteById(id);
    }
}
