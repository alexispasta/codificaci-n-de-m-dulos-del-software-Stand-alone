// Paquete en el que se encuentra esta clase
package com.sgrh.demo.controller;

// Importaciones necesarias para listas y opcionales
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

import com.sgrh.demo.modelo.Certificado;
import com.sgrh.demo.repositorio.CertificadoRepository;

// Anotación que define esta clase como un controlador REST
@RestController
// Ruta base para las solicitudes HTTP relacionadas con certificados
@RequestMapping("/certificados")
public class CertificadoController {

    // Inyección del repositorio para acceder a operaciones de base de datos
    @Autowired
    private CertificadoRepository certificadoRepository;

    // Crear un nuevo certificado (operación POST)
    @PostMapping
    public Certificado registrarCertificado(@RequestBody Certificado certificado) {
        // Guarda el certificado en la base de datos y lo retorna
        return certificadoRepository.save(certificado);
    }

    // Obtener todos los certificados (operación GET)
    @GetMapping
    public List<Certificado> listarCertificados() {
        // Retorna una lista con todos los certificados encontrados
        return certificadoRepository.findAll();
    }

    // Obtener un certificado por ID (operación GET)
    @GetMapping("/{id}")
    public Certificado obtenerCertificado(@PathVariable Integer id) {
        // Busca y retorna el certificado por ID o null si no existe
        return certificadoRepository.findById(id).orElse(null);
    }

    // Actualizar un certificado existente (operación PUT)
    @PutMapping("/{id}")
    public Certificado actualizarCertificado(@PathVariable Integer id, @RequestBody Certificado certificadoActualizado) {
        // Busca el certificado por ID
        Optional<Certificado> optional = certificadoRepository.findById(id);

        // Si se encuentra el certificado, se actualizan sus valores
        if (optional.isPresent()) {
            Certificado existente = optional.get();
            // Se copian los nuevos valores al objeto existente
            existente.setIdPersona(certificadoActualizado.getIdPersona());
            existente.setNombrePersona(certificadoActualizado.getNombrePersona());
            existente.setCarrera(certificadoActualizado.getCarrera());
            existente.setFechaInicio(certificadoActualizado.getFechaInicio());
            existente.setInstitucion(certificadoActualizado.getInstitucion());

            // Se guarda y retorna el certificado actualizado
            return certificadoRepository.save(existente);
        } else {
            // Si no se encuentra, se retorna null
            return null;
        }
    }

    // Eliminar un certificado por ID (operación DELETE)
    @DeleteMapping("/{id}")
    public void eliminarCertificado(@PathVariable Integer id) {
        // Elimina el certificado con el ID especificado
        certificadoRepository.deleteById(id);
    }

}
