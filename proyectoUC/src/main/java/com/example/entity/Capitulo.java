package com.example.entity;

import java.util.Objects;

import javax.persistence.Id;

public class Capitulo {
	
	@Id
	private Integer numero_capitulo;
	private String titulo;
	private String enlace;
	private String descripcion;
	
	public Integer getNumero_capitulo() {
		return numero_capitulo;
	}
	public void setNumero_capitulo(Integer numero_capitulo) {
		this.numero_capitulo = numero_capitulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capitulo that = (Capitulo) o;
        return	numero_capitulo == that.numero_capitulo &&
        		Objects.equals(titulo, that.titulo) &&
        		Objects.equals(enlace, that.enlace) &&
        		Objects.equals(descripcion, that.descripcion);       
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero_capitulo, titulo, enlace, descripcion);
    }
}
