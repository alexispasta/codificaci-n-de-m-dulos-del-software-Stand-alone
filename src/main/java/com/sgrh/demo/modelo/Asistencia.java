// Paquete donde se encuentra la clase Asistencia
package com.sgrh.demo.modelo;

// Importaciones necesarias para la persistencia y serialización
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Indica que esta clase es una entidad JPA
@Entity
// Especifica el nombre de la tabla en la base de datos
@Table(name = "asistencia")
public class Asistencia {

    // Identificador único (clave primaria) generado automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación muchos-a-uno con la tabla Persona (autor del registro)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false) // Columna que representa al autor
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignora propiedades internas de Hibernate al serializar
    private Persona autor;

    // Relación muchos-a-uno con la tabla Persona (persona evaluada)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false) // Columna que representa a la persona afectada
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;

    // Nombre completo de la persona (redundante pero útil para reportes)
    @Column(name = "nombre_persona")
    private String nombrePersona;

    // Documento de identidad de la persona (también redundante pero útil)
    @Column(name = "documento_identidad")
    private String documentoIdentidad;

    // Cantidad de días faltados
    @Column(name = "dias_faltados")
    private Integer diasFaltados;

    // Getters y Setters

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

    public Integer getDiasFaltados() {
        return diasFaltados;
    }

    public void setDiasFaltados(Integer diasFaltados) {
        this.diasFaltados = diasFaltados;
    }
}
