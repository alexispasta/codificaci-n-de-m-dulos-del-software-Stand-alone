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

import com.sgrh.demo.modelo.Empleado;
import com.sgrh.demo.repositorio.EmpleadoRepository;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Crear
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // Leer todos
    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    // Leer uno por ID
    @GetMapping("/{id}")
    public Empleado obtenerEmpleado(@PathVariable Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoActualizado) {
        Optional<Empleado> optional = empleadoRepository.findById(id);
        if (optional.isPresent()) {
            Empleado existente = optional.get();
            existente.setPersona(empleadoActualizado.getPersona());
            existente.setFechaContratacion(empleadoActualizado.getFechaContratacion());
            existente.setCargo(empleadoActualizado.getCargo());
            return empleadoRepository.save(existente);
        } else {
            return null;
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Integer id) {
        empleadoRepository.deleteById(id);
    }
}
