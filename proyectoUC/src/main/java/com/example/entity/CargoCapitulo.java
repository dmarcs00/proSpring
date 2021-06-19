package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.views.View.DescripcionUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class CargoCapitulo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView({DescripcionUsuario.class})
	private Integer id;
	@OneToOne(cascade=CascadeType.ALL)
	private Capitulo capitulo;
	@JsonView({DescripcionUsuario.class})
	private String temporada_x_capitulo;
	@JsonView({DescripcionUsuario.class})
	private double precio;
	@JsonView({DescripcionUsuario.class})
	private String fecha;
	@JsonView({DescripcionUsuario.class})
	private String nombre_serie;
	@ManyToOne
	@JsonIgnore
	private Factura factura;
	
	public CargoCapitulo(Capitulo capitulo, String fecha, Factura factura) {
		super();
		this.capitulo = capitulo;
		this.fecha = fecha;
		this.factura = factura;
		this.precio = capitulo.getTemporada().getSerie().getCategoria().getPrecio();
		this.temporada_x_capitulo = capitulo.getTemporada().getNumero_temporada().toString() + "x" + capitulo.getNumero_capitulo().toString();
		this.nombre_serie = capitulo.getTemporada().getSerie().getNombre_serie();

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
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	
	public String getTemporada_x_capitulo() {
		return temporada_x_capitulo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getPrecio() {
		return precio;
	}
	public String getNombre_serie() {
		return nombre_serie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capitulo == null) ? 0 : capitulo.hashCode());
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		return true;
	}
	
}
