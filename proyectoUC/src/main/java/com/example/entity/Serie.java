package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity
public class Serie {
	@Id
	private Integer numero_serie;
	private String descripcion;
	private List<Temporada> temporadas = new ArrayList<>();
	private Categoria categoria; //duda de como aplicar la herencia y los precios

    public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@OneToMany(mappedBy = "Serie")
    public List<Temporada> getPedidos() {
        return temporadas;
    }
    public void setTemporada(List<Temporada> temporadas) {
    	this.temporadas = temporadas;
    }
	public int getNumero_serie() {
		return numero_serie;
	}

	public void setNumero_serie(int numero_serie) {
		this.numero_serie = numero_serie;
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
        Serie that = (Serie) o;
        return numero_serie == that.numero_serie &&
                Objects.equals(descripcion, that.descripcion);          
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero_serie, descripcion);
    }

}
