// Paquete donde se encuentra esta clase dentro del proyecto
package com.sgrh.demo.modelo;

// Importaciones necesarias para trabajar con fechas
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Esta clase será una entidad JPA (una tabla en la base de datos)
@Entity

// Especifica el nombre de la tabla en la base de datos
@Table(name = "persona")

// Indica que se deben ignorar ciertas propiedades internas de Hibernate al convertir a JSON
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona {

    // Campo clave primaria, generado automáticamente (auto-incremental)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Atributos básicos de la persona
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;

    // Documento único, no se puede repetir en la base de datos
    @Column(name = "documento_identidad", unique = true)
    private String documentoIdentidad;

    // Fechas de nacimiento y contratación
    private LocalDate fechaNacimiento;
    private LocalDate fechaContratacion;

    // Enum que representa el tipo de contrato laboral. Se guarda como texto en la BD
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contrato")
    private TipoContrato tipoContrato;

    // Enum que representa el rol de la persona. Se guarda como texto
    @Enumerated(EnumType.STRING)
    private Rol rol;

    // Estado activo o inactivo de la persona en el sistema
    private Boolean activo;

    // Contraseña para acceder al sistema
    private String contrasena;

    // Relación con la tabla empresa: muchas personas pueden estar en una empresa
    @ManyToOne
    @JoinColumn(name = "id_empresa") // Llave foránea
    private Empresa empresa;

    // Enumeración para los tipos de contrato permitidos
    public enum TipoContrato {
        termino_fijo, termino_indefinido, prestacion_de_servicios
    }

    // Enumeración para los roles permitidos en el sistema
    public enum Rol {
        empleado, supervisor, RRHH, gerente
    }

    // Getters y Setters para acceder y modificar los atributos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
