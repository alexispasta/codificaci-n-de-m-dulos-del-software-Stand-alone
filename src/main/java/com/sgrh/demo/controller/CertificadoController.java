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

import com.sgrh.demo.modelo.Certificado;
import com.sgrh.demo.repositorio.CertificadoRepository;


@RestController
@RequestMapping("/certificados")
public class CertificadoController {

    @Autowired
    private CertificadoRepository certificadoRepository;

    // CREAR
    @PostMapping
    public Certificado registrarCertificado(@RequestBody Certificado certificado) {
        return certificadoRepository.save(certificado);
    }

    // LEER TODOS
    @GetMapping
    public List<Certificado> listarCertificados() {
        return certificadoRepository.findAll();
    }

    @GetMapping("/{id}")
public Certificado obtenerCertificado(@PathVariable Integer id) {
    return certificadoRepository.findById(id).orElse(null);
}

@PutMapping("/{id}")
public Certificado actualizarCertificado(@PathVariable Integer id, @RequestBody Certificado certificadoActualizado) {
    Optional<Certificado> optional = certificadoRepository.findById(id);

    if (optional.isPresent()) {
        Certificado existente = optional.get();
        existente.setIdPersona(certificadoActualizado.getIdPersona());
        existente.setNombrePersona(certificadoActualizado.getNombrePersona());
        existente.setCarrera(certificadoActualizado.getCarrera());
        existente.setFechaInicio(certificadoActualizado.getFechaInicio());
        existente.setInstitucion(certificadoActualizado.getInstitucion());
        return certificadoRepository.save(existente);
    } else {
        return null;
    }
}

@DeleteMapping("/{id}")
public void eliminarCertificado(@PathVariable Integer id) {
    certificadoRepository.deleteById(id);
}

}
