package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.example.views.View.DescripcionSerie;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	@JsonView({DescripcionSerie.class})
	protected double precio;
	@JsonView({DescripcionSerie.class})
	private String nombre;
	
	public Categoria(double precio, String nombre) {
		super();
		this.precio = precio;
		this.nombre = nombre;
	}
	protected Categoria() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecio() {
		return this.precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
