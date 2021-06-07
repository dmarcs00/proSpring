package com.example.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CargoCapitulo {
	@Id
	@GeneratedValue
	private Integer id;
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	private Capitulo capitulo;
	private double precio;
	private String fecha;
	private String nombre_serie;
	private String temporada_x_capitulo;
	@ManyToOne
	@JsonIgnore
	private Factura factura;
	
	public CargoCapitulo(Capitulo capitulo, String fecha, Factura factura) {
		super();
		this.capitulo = capitulo;
		this.fecha = fecha;
		this.factura = factura;
		this.nombre_serie = capitulo.getTemporada().getSerie().nombre_serie;
		this.temporada_x_capitulo = capitulo.getTemporada().getNumero_temporada().toString() + "x" + capitulo.getNumero_capitulo().toString();
		this.precio = capitulo.getTemporada().getSerie().getCategoria().getPrecio();
	}
	protected CargoCapitulo() {
		
	}
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
	public String getNombre_serie() {
		return nombre_serie;
	}
	public void setNombre_serie(String nombre_serie) {
		this.nombre_serie = nombre_serie;
	}
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTemporada_x_capitulo() {
		return temporada_x_capitulo;
	}
	public void setTemporada_x_capitulo(String temporada_x_capitulo) {
		this.temporada_x_capitulo = temporada_x_capitulo;
	}
	public double getPrecio() {
		return precio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capitulo == null) ? 0 : capitulo.hashCode());
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre_serie == null) ? 0 : nombre_serie.hashCode());
		result = prime * result + ((temporada_x_capitulo == null) ? 0 : temporada_x_capitulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CargoCapitulo other = (CargoCapitulo) obj;
		if (capitulo == null) {
			if (other.capitulo != null)
				return false;
		} else if (!capitulo.equals(other.capitulo))
			return false;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre_serie == null) {
			if (other.nombre_serie != null)
				return false;
		} else if (!nombre_serie.equals(other.nombre_serie))
			return false;
		if (temporada_x_capitulo == null) {
			if (other.temporada_x_capitulo != null)
				return false;
		} else if (!temporada_x_capitulo.equals(other.temporada_x_capitulo))
			return false;
		return true;
	}
	
}
