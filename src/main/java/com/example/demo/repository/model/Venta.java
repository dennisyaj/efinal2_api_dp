package com.example.demo.repository.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_venta")
	@SequenceGenerator(name = "seq_venta", sequenceName = "seq_venta", allocationSize = 1)
	@Column(name = "vent_id")
	private Integer id;
	@Column(name = "vent_numero_venta")
	private String numeroVenta;
	@Column(name = "vent_cedula_cliente")
	private String cedulaCliente;
	@Column(name = "vent_total_venta")
	private BigDecimal totalVenta;
	
	@OneToMany(mappedBy = "ventas", cascade = CascadeType.ALL)
	private List<DetalleVenta> listDetalleVentas;
	//gets and sets

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(String numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<DetalleVenta> getListDetalleVentas() {
		return listDetalleVentas;
	}

	public void setListDetalleVentas(List<DetalleVenta> listDetalleVentas) {
		this.listDetalleVentas = listDetalleVentas;
	}
	
	
	
}
