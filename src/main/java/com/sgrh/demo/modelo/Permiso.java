// Paquete del proyecto donde se ubica la clase
package com.sgrh.demo.modelo;

// Importación de clase para manejar fechas sin zona horaria
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Declara esta clase como una entidad JPA (representará una tabla en la base de datos)
@Entity

// Define el nombre de la tabla en la base de datos
@Table(name = "permiso")
public class Permiso {

    // Clave primaria de la tabla 'permiso', autogenerada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación muchos-a-uno: el autor del permiso es una persona
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false) // Columna FK obligatoria
    private Persona autor;

    // Relación muchos-a-uno: el permiso es para otra persona
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false) // Columna FK obligatoria
    private Persona persona;

    // Nombre completo de la persona a la que se le otorga el permiso
    @Column(name = "nombre_persona")
    private String nombrePersona;

    // Documento de identidad de la persona a la que se le otorga el permiso
    @Column(name = "documento_identidad")
    private String documentoIdentidad;

    // Razón o motivo del permiso
    private String razon;

    // Fecha en que se solicitó el permiso
    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    // Fecha en que se aplica o concede el permiso
    @Column(name = "fecha_aplicacion")
    private LocalDate fechaAplicacion;

    // Getters y Setters: métodos públicos para acceder y modificar los atributos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }
}
