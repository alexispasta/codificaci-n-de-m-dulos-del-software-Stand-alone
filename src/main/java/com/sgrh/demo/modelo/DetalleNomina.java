package com.sgrh.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_nomina")
public class DetalleNomina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    private String cuentaBancaria;
    private Double salarioBase;
    private Double auxilioTransporte;
    private Integer horasExtra;
    private Double bonificacion;
    private Double comisiones;
    private Double viaticos;
    private Double descuentos;
    private Double retencionFuente;
    private Double prestamosEmpresa;
    private Double embargosJudiciales;
    private Integer incapacidadesDias;
    private Integer vacacionesDias;
    private Double cesantias;
    private Double interesesCesantias;
    private Double primaServicios;
    private Double totalPagar;

    // Getters y Setters

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
