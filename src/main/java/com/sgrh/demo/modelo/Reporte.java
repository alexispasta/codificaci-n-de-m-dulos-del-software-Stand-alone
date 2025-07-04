// Paquete donde se encuentra la clase
package com.sgrh.demo.modelo;

// Importación para manejar fechas (sin zona horaria)
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Esta clase representa una entidad JPA que se mapeará a una tabla en la base de datos
@Entity

// Indica el nombre de la tabla que esta entidad representa
@Table(name = "reporte")
public class Reporte {

    // Identificador único del reporte, generado automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación muchos-a-uno con la entidad Persona, representa al autor del reporte
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false) // Llave foránea, no puede ser null
    private Persona autor;

    // Relación muchos-a-uno con la entidad Persona, representa a la persona reportada
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false) // Llave foránea, no puede ser null
    private Persona persona;

    // Nombre de la persona que fue reportada (se guarda como texto)
    @Column(name = "nombre_persona")
    private String nombrePersona;

    // Motivo del reporte
    private String razon;

    // Fecha en que se realizó el reporte
    @Column(name = "fecha_reporte")
    private LocalDate fechaReporte;

    // Comentarios adicionales del reporte
    private String comentarios;

    // Métodos getters y setters para acceder y modificar los atributos

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

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
