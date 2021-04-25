package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Temporada {
	
	@Id
	@GeneratedValue
	protected int numero_temporada;
	@OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL)
	protected List<Capitulo> capitulos = new ArrayList<>();
	@ManyToOne
	protected Serie serie;
	

	public Temporada(Serie serie) {
		super();
		this.serie = serie;
	}
	public List<Capitulo> getCapitulos() {
        return this.capitulos;
    }
    public void setCapitulos(List<Capitulo> capitulos) {
    	this.capitulos = capitulos;
    }
	public int getNumero_temporada() {
		return numero_temporada;
	}
	public void setNumero_temporada(int numero_temporada) {
		this.numero_temporada = numero_temporada;
	}
	
	public Serie getSerie() {
		return serie;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temporada that = (Temporada) o;
        return numero_temporada == that.numero_temporada;              
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero_temporada);
    }
	
}
