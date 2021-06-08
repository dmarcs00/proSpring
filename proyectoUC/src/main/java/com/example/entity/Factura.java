package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.views.View.DescripcionSerie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Id;
@Entity
public class Factura {
	@Id
	@JsonView({DescripcionSerie.class})
	private String num_factura;
	@OneToMany(mappedBy = "factura", cascade=CascadeType.ALL)
	@JsonView({DescripcionSerie.class})
	private List<CargoCapitulo> capitulos_vistos_factura = new ArrayList<>();
	@ManyToOne
	@JsonIgnore
	private Usuario usuario;
	
	public Factura(String num_factura, Usuario usuario) {
		super();
		this.num_factura = num_factura;
		this.usuario = usuario;
	}

	protected Factura() {}
	
    public List<CargoCapitulo> getCapitulosVistosFactura() {
        return this.capitulos_vistos_factura;
    }
	
	public String getNum_factura() {
		return num_factura;
	}
	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}

	public void setCapitulos_vistos_factura(List<CargoCapitulo> capitulos_vistos_factura) {
		this.capitulos_vistos_factura = capitulos_vistos_factura;
	}
	
}
