// Paquete base donde se encuentra esta clase controladora
package com.sgrh.demo.controller;

// Importaciones necesarias para manejar listas y valores opcionales
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

import com.sgrh.demo.modelo.Empresa;
import com.sgrh.demo.repositorio.EmpresaRepository;

// Anotación que define esta clase como un controlador REST
@RestController
// Define la ruta base para acceder a los servicios relacionados con empresas
@RequestMapping("/empresas")
public class EmpresaController {

    // Inyección automática del repositorio EmpresaRepository
    @Autowired
    private EmpresaRepository empresaRepository;

    // Método para crear una nueva empresa (operación HTTP POST)
    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        // Guarda el objeto empresa recibido en la base de datos y lo retorna
        return empresaRepository.save(empresa);
    }

    // Método para obtener todas las empresas (operación HTTP GET)
    @GetMapping
    public List<Empresa> obtenerEmpresas() {
        // Retorna una lista con todas las empresas existentes en la base de datos
        return empresaRepository.findAll();
    }

    // Método para obtener una empresa por su ID (operación HTTP GET)
    @GetMapping("/{id}")
    public Empresa obtenerEmpresa(@PathVariable Integer id) {
        // Busca la empresa por ID y la retorna si existe, de lo contrario retorna null
        return empresaRepository.findById(id).orElse(null);
    }

    // Método para actualizar una empresa existente (operación HTTP PUT)
    @PutMapping("/{id}")
    public Empresa actualizarEmpresa(@PathVariable Integer id, @RequestBody Empresa empresaActualizada) {
        // Busca la empresa por su ID usando un Optional
        Optional<Empresa> optional = empresaRepository.findById(id);

        // Si la empresa existe, se actualizan sus atributos
        if (optional.isPresent()) {
            Empresa existente = optional.get();
            existente.setNombre(empresaActualizada.getNombre());
            existente.setTelefono(empresaActualizada.getTelefono());
            existente.setDireccion(empresaActualizada.getDireccion());
            existente.setCiudad(empresaActualizada.getCiudad());
            existente.setPais(empresaActualizada.getPais());

            // Guarda y retorna la empresa actualizada
            return empresaRepository.save(existente);
        } else {
            // Si no existe, retorna null
            return null;
        }
    }

    // Método para eliminar una empresa por su ID (operación HTTP DELETE)
    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable Integer id) {
        // Elimina la empresa con el ID especificado de la base de datos
        empresaRepository.deleteById(id);
    }
}
