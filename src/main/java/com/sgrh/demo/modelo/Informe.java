// Paquete donde se encuentra la clase Informe (estructura lógica del proyecto)
package com.sgrh.demo.modelo;

// Importaciones de anotaciones JPA necesarias para el mapeo de la entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Marca esta clase como una entidad JPA (se mapeará a una tabla en la base de datos)
@Entity

// Indica el nombre de la tabla en la base de datos asociada a esta entidad
@Table(name = "informe")
public class Informe {

    // Clave primaria de la tabla, autogenerada con incremento automático
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación muchos-a-uno con la entidad Persona (autor del informe)
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false) // Nombre de la columna y que no puede ser nula
    private Persona autor;

    // Relación muchos-a-uno con la entidad Empresa (empresa a la que pertenece el informe)
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false) // Nombre de la columna y que no puede ser nula
    private Empresa empresa;

    // Campo para el asunto o título del informe
    private String asunto;

    // Campo para el contenido del informe (comentario o cuerpo del texto)
    private String comentario;

    // Getters y Setters para acceder y modificar los campos de la clase

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
