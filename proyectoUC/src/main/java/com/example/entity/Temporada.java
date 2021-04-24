package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity
public class Temporada {
	
	@Id
	@GeneratedValue
	private int numero_temporada;
	@OneToMany(mappedBy = "Temporada")
	private List<Temporada> capitulos = new ArrayList<>();
	@ManyToOne
	private Serie serie;
	
    public List<Temporada> getCapitulos() {
        return this.capitulos;
    }
    public void setTemporada(List<Temporada> temporadas) {
    	this.capitulos = temporadas;
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
