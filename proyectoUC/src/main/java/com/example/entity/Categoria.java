package com.example.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Categoria {

	@Id
	@GeneratedValue
	protected Integer id;
	protected double precio;
	
	public Categoria(double precio) {
		this.precio = precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecio() {
		return this.precio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
