package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.views.View.DescripcionUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class SeriesVisualizada {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView({DescripcionUsuario.class})
	private Integer id;
	@ManyToOne
	private Usuario usuario;
	@JsonView({DescripcionUsuario.class})
	private int ultimo_capitulo_visto;
	@OneToOne
	@JsonView({DescripcionUsuario.class})
	private Serie serie;
	
	
	public SeriesVisualizada(Usuario usuario, int ultimo_capitulo_visto, Serie serie) {
		super();
		this.usuario = usuario;
		this.ultimo_capitulo_visto = ultimo_capitulo_visto;
		this.serie = serie;
	}

	protected SeriesVisualizada() {
		
	}
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public int getUltimo_capitulo_visto() {
		return ultimo_capitulo_visto;
	}



	public void setUltimo_capitulo_visto(int ultimo_capitulo_visto) {
		this.ultimo_capitulo_visto = ultimo_capitulo_visto;
	}



	public Serie getSerie() {
		return serie;
	}



	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + ultimo_capitulo_visto;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SeriesVisualizada))
			return false;
		SeriesVisualizada other = (SeriesVisualizada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (ultimo_capitulo_visto != other.ultimo_capitulo_visto)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
