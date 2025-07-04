// Paquete donde se encuentra esta clase, según la estructura del proyecto
package com.sgrh.demo.modelo;

// Importaciones necesarias para trabajar con fechas y valores decimales
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Marca esta clase como una entidad JPA (se convierte en una tabla en la base de datos)
@Entity

// Define el nombre de la tabla en la base de datos asociada a esta clase
@Table(name = "nomina")

// Evita errores al trabajar con Hibernate y serialización JSON
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nomina {

    // Campo 'id' es la clave primaria y se genera automáticamente con auto-incremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación muchos-a-uno con la entidad Persona. Cada nómina está asociada a una persona
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false) // Define la columna FK y que no puede ser nula
    private Persona persona;

    // Fecha en la que se realizó el pago de la nómina
    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    // Monto total pagado en esta nómina
    private BigDecimal cantidad;

    // Getters y Setters para acceder y modificar los atributos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
}
