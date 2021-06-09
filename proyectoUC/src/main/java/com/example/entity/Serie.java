package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
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
	@GeneratedValue
	@JsonView({DescripcionSerie.class})
	protected Integer numero_serie;
	@JsonView({DescripcionSerie.class})
	protected String nombre_serie;
	@JsonView({DescripcionSerie.class})
	protected String descripcion;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonView({DescripcionSerie.class})
	protected Categoria categoria;
	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
	@JsonView({DescripcionSerie.class})
	protected List<Temporada> temporadas = new ArrayList<>();
	@ElementCollection
	@OrderColumn(name="actores")
	@JsonView({DescripcionSerie.class})
	protected List<Actor> actores = new ArrayList<>();
	@ElementCollection
	@OrderColumn(name="creadores")
	@JsonView({DescripcionSerie.class})
	protected List<Creador> creadores = new ArrayList<>();
	
	protected Serie() {
		
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

	@Override
	public String toString() {
		return "Serie [numero_serie=" + numero_serie + ", nombre_serie=" + nombre_serie + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", temporadas=" + temporadas + ", actores=" + actores + ", creadores="
				+ creadores + "]";
	}
    
}
