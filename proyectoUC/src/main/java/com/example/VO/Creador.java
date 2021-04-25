package com.example.VO;

import javax.persistence.Embeddable;

@Embeddable
public class Creador {
	
	private String nombre;
	private String apellidos;
	
	public Creador(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
