// Paquete donde se encuentra la clase Certificado
package com.sgrh.demo.modelo;

// Importaciones necesarias para trabajar con fechas y anotaciones JPA
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indica que esta clase es una entidad JPA que se mapeará a una tabla de base de datos
@Entity
// Especifica el nombre de la tabla correspondiente en la base de datos
@Table(name = "certificado")
public class Certificado {

    // Identificador único del certificado, clave primaria con autoincremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // ID de la persona asociada al certificado (clave foránea en la tabla)
    @Column(name = "id_persona")
    private int idPersona;

    // Nombre completo de la persona asociada (campo redundante para visualización rápida)
    @Column(name = "nombre_persona")
    private String nombrePersona;

    // Carrera o profesión certificada
    private String carrera;

    // Fecha de inicio de los estudios o validez del certificado
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    // Institución que emite el certificado
    private String institucion;

    // Métodos getter y setter para acceder y modificar cada campo

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
}
