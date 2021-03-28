package com.example.entity;

import java.util.Objects;

import javax.persistence.Entity;
@Entity
public class Actor {
	private String nombre;
	private String apellidos;
	
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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor that = (Actor) o;
        return	Objects.equals(nombre, that.nombre) &&
        		Objects.equals(apellidos, that.apellidos);       
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos);
    }
}
