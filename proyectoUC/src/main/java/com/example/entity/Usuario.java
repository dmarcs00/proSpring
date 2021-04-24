package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	private String usuarioId;
	private String password;
	private String IBAN;
	private boolean es_VIP;
	@ManyToMany
	private List<Serie> series_pendientes = new ArrayList<>();
	@ManyToMany
	private List<Serie> series_finalizadas = new ArrayList<>();
	@ManyToMany
	private List<SeriesVisualizada> series_empezadas = new ArrayList<>();
	@OneToMany(mappedBy = "Usuario")
	private List<Factura> facturas = new ArrayList<>();
	
	protected Usuario () {
		
	}
	
	public Usuario(String usuarioId, String password, String iBAN, boolean es_VIP, List<Serie> series_pendientes,
			List<Serie> series_finalizadas, List<SeriesVisualizada> series_empezadas, List<Factura> facturas) {
		super();
		this.usuarioId = usuarioId;
		this.password = password;
		IBAN = iBAN;
		this.es_VIP = es_VIP;
		this.series_pendientes = series_pendientes;
		this.series_finalizadas = series_finalizadas;
		this.series_empezadas = series_empezadas;
		this.facturas = facturas;
	}

	
    public List<Factura> getFactura() {
        return facturas;
    }
	
	public void setFactura(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
    public List<Serie> getSeriesPendientes() {
        return series_pendientes;
    }
	
	public void setSeriesPendientes(List<Serie> series_pendientes) {
		this.series_pendientes = series_pendientes;
	}
	
	
    public List<Serie> getSeriesFinalizadas() {
        return series_finalizadas;
    }
	
	public void setSeriesFinalizadas(List<Serie> series_finalizadas) {
		this.series_finalizadas = series_finalizadas;
	}
	
    public List<SeriesVisualizada> getSeriesEmpezadas() {
        return series_empezadas;
    }
	
	public void setSeriesEmpezadas(List<SeriesVisualizada> series_empezadas) {
		this.series_empezadas = series_empezadas;
	}
	
	
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public boolean isEs_VIP() {
		return es_VIP;
	}
	public void setEs_VIP(boolean es_VIP) {
		this.es_VIP = es_VIP;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario that = (Usuario) o;
        return	es_VIP == that.es_VIP &&
        		Objects.equals(usuarioId, that.usuarioId) &&
        		Objects.equals(password, that.password) &&
                Objects.equals(IBAN, that.IBAN);          
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, password, IBAN, es_VIP);
    }
	
}
