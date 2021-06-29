package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

import com.example.VO.Actor;
import com.example.VO.Creador;
import com.example.views.View.DescripcionSerie;
import com.example.views.View.DescripcionUsuario;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Id;

@Entity
public class Serie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView({DescripcionSerie.class, DescripcionUsuario.class})
	protected Integer numero_serie;
	@JsonView({DescripcionSerie.class, DescripcionUsuario.class})
	protected String nombre_serie;
	@JsonView({DescripcionSerie.class})
	protected String descripcion;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonView({DescripcionSerie.class})
	protected Categoria categoria;
	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
	@JsonView({DescripcionSerie.class, DescripcionUsuario.class})
	protected List<Temporada> temporadas = new ArrayList<>();
	@ElementCollection
	@OrderColumn(name="actores")
	@JsonView({DescripcionSerie.class})
	protected List<Actor> actores = new ArrayList<>();
	@ElementCollection
	@OrderColumn(name="creadores")
	@JsonView({DescripcionSerie.class})
	protected List<Creador> creadores = new ArrayList<>();
	
	public Serie() {
		
	}

	//Sin las temporadas. Crear otropara meter temporadas?
    public Serie(String nombre_serie, String descripcion, Categoria categoria) {
		super();	
		this.nombre_serie = nombre_serie;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

	public String getNombre_serie() {
		return nombre_serie;
	}

	public void setNombre_serie(String nombre_serie) {
		this.nombre_serie = nombre_serie;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
    public List<Temporada> getTemporadas() {
        return temporadas;
    }
    
	public void setTemporada(List<Temporada> temporadas) {
    	this.temporadas = temporadas;
    }
	public Integer getNumero_serie() {
		return numero_serie;
	}

	public void setNumero_serie(Integer numero_serie) {
		this.numero_serie = numero_serie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public List<Creador> getCreadores() {
		return creadores;
	}

	public void setCreadores(List<Creador> creadores) {
		this.creadores = creadores;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Serie))
			return false;
		Serie other = (Serie) obj;
		if (nombre_serie == null) {
			if (other.nombre_serie != null)
				return false;
		} else if (!nombre_serie.equals(other.nombre_serie))
			return false;
		if (numero_serie == null) {
			if (other.numero_serie != null)
				return false;
		} else if (!numero_serie.equals(other.numero_serie))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre_serie == null) ? 0 : nombre_serie.hashCode());
		result = prime * result + ((numero_serie == null) ? 0 : numero_serie.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Serie [numero_serie=" + numero_serie + ", nombre_serie=" + nombre_serie + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", temporadas=" + temporadas + ", actores=" + actores + ", creadores="
				+ creadores + "]";
	}
    
}
