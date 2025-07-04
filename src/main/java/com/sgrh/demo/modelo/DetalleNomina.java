// Paquete donde se encuentra la clase DetalleNomina
package com.sgrh.demo.modelo;

// Importaciones necesarias de JPA para la entidad y sus relaciones
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Indica que esta clase es una entidad JPA (se mapea a una tabla de base de datos)
@Entity
// Indica el nombre de la tabla en la base de datos
@Table(name = "detalle_nomina")
public class DetalleNomina {

    // Identificador único del registro (clave primaria, autogenerada)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación muchos-a-uno con la entidad Persona (quien recibe la nómina)
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    // Número de cuenta bancaria donde se deposita la nómina
    private String cuentaBancaria;

    // Salario base mensual
    private Double salarioBase;

    // Auxilio de transporte (si aplica)
    private Double auxilioTransporte;

    // Cantidad de horas extra trabajadas en el mes
    private Integer horasExtra;

    // Valor de bonificaciones otorgadas
    private Double bonificacion;

    // Valor total de comisiones por desempeño u otros conceptos
    private Double comisiones;

    // Viáticos asignados durante el mes
    private Double viaticos;

    // Total de descuentos aplicados (por ejemplo, préstamos, sanciones)
    private Double descuentos;

    // Retención en la fuente aplicada al salario
    private Double retencionFuente;

    // Valor descontado por préstamos otorgados por la empresa
    private Double prestamosEmpresa;

    // Valor descontado por embargos judiciales
    private Double embargosJudiciales;

    // Días que el empleado estuvo incapacitado en el mes
    private Integer incapacidadesDias;

    // Días de vacaciones disfrutadas en el mes
    private Integer vacacionesDias;

    // Valor de cesantías acumuladas
    private Double cesantias;

    // Intereses sobre las cesantías
    private Double interesesCesantias;

    // Prima de servicios correspondiente al periodo
    private Double primaServicios;

    // Total a pagar al empleado tras aplicar todos los conceptos anteriores
    private Double totalPagar;

    // Getters y setters (métodos para acceder y modificar los atributos)

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public String getCuentaBancaria() { return cuentaBancaria; }
    public void setCuentaBancaria(String cuentaBancaria) { this.cuentaBancaria = cuentaBancaria; }

    public Double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(Double salarioBase) { this.salarioBase = salarioBase; }

    public Double getAuxilioTransporte() { return auxilioTransporte; }
    public void setAuxilioTransporte(Double auxilioTransporte) { this.auxilioTransporte = auxilioTransporte; }

    public Integer getHorasExtra() { return horasExtra; }
    public void setHorasExtra(Integer horasExtra) { this.horasExtra = horasExtra; }

    public Double getBonificacion() { return bonificacion; }
    public void setBonificacion(Double bonificacion) { this.bonificacion = bonificacion; }

    public Double getComisiones() { return comisiones; }
    public void setComisiones(Double comisiones) { this.comisiones = comisiones; }

    public Double getViaticos() { return viaticos; }
    public void setViaticos(Double viaticos) { this.viaticos = viaticos; }

    public Double getDescuentos() { return descuentos; }
    public void setDescuentos(Double descuentos) { this.descuentos = descuentos; }

    public Double getRetencionFuente() { return retencionFuente; }
    public void setRetencionFuente(Double retencionFuente) { this.retencionFuente = retencionFuente; }

    public Double getPrestamosEmpresa() { return prestamosEmpresa; }
    public void setPrestamosEmpresa(Double prestamosEmpresa) { this.prestamosEmpresa = prestamosEmpresa; }

    public Double getEmbargosJudiciales() { return embargosJudiciales; }
    public void setEmbargosJudiciales(Double embargosJudiciales) { this.embargosJudiciales = embargosJudiciales; }

    public Integer getIncapacidadesDias() { return incapacidadesDias; }
    public void setIncapacidadesDias(Integer incapacidadesDias) { this.incapacidadesDias = incapacidadesDias; }

    public Integer getVacacionesDias() { return vacacionesDias; }
    public void setVacacionesDias(Integer vacacionesDias) { this.vacacionesDias = vacacionesDias; }

    public Double getCesantias() { return cesantias; }
    public void setCesantias(Double cesantias) { this.cesantias = cesantias; }

    public Double getInteresesCesantias() { return interesesCesantias; }
    public void setInteresesCesantias(Double interesesCesantias) { this.interesesCesantias = interesesCesantias; }

    public Double getPrimaServicios() { return primaServicios; }
    public void setPrimaServicios(Double primaServicios) { this.primaServicios = primaServicios; }

    public Double getTotalPagar() { return totalPagar; }
    public void setTotalPagar(Double totalPagar) { this.totalPagar = totalPagar; }
}
