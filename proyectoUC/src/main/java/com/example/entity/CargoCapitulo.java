package com.example.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CargoCapitulo {
	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne(cascade=CascadeType.ALL)
	private Capitulo capitulo;
	@OneToOne(cascade=CascadeType.ALL)
	private Serie serie;
	private double precio;
	private Date fecha;
	@ManyToOne
	private Factura factura;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
