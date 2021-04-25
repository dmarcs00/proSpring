package com.example.VO;


import javax.persistence.Embeddable;


@Embeddable
public class Actor {
	
	protected String nombre;
	protected String apellidos;
	
	protected Actor() {
		
	}
	public Actor(String nombre, String apellidos) {
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
