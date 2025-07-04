// Paquete donde se encuentra esta clase (estructura de paquetes del proyecto)
package com.sgrh.demo.modelo;

// Importaciones necesarias para la anotación de entidades JPA
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indica que esta clase es una entidad JPA que se mapeará a una tabla en la base de datos
@Entity

// Especifica el nombre de la tabla que se generará o usará en la base de datos
@Table(name = "empresa")
public class Empresa {

    // Clave primaria de la tabla, autogenerada con incremento automático
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre de la empresa
    private String nombre;

    // Número de teléfono de contacto
    private String telefono;

    // Dirección física de la empresa
    private String direccion;

    // Ciudad donde se encuentra la empresa
    private String ciudad;

    // País de origen o donde está registrada la empresa
    private String pais;

    // Métodos Getter y Setter para acceder y modificar los atributos de la clase

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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
