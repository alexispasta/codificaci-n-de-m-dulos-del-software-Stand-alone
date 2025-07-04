package com.sgrh.demo.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificado")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_persona")
    private int idPersona;

    @Column(name = "nombre_persona")
    private String nombrePersona;

    private String carrera;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    private String institucion;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public String getNombrePersona() { return nombrePersona; }
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }
}
