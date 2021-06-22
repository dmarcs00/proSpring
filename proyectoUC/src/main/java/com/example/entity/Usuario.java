package com.example.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.views.View.DescripcionUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;



@Entity
public class Usuario {
	
	@Id
	@JsonView({DescripcionUsuario.class})
	private String usuarioId;
	@JsonView({DescripcionUsuario.class})
	private String password;
	@JsonView({DescripcionUsuario.class})
	private String IBAN;
	@JsonView({DescripcionUsuario.class})
	private boolean es_VIP;
	@ManyToMany
	@JsonView({DescripcionUsuario.class})
	private List<Serie> series_pendientes = new ArrayList<>();
	
	@ManyToMany
	@JsonView({DescripcionUsuario.class})
	private List<Serie> series_finalizadas = new ArrayList<>();
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonView({DescripcionUsuario.class})
	private List<SeriesVisualizada> series_empezadas = new ArrayList<>();
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonView({DescripcionUsuario.class})
	private List<Factura> facturas = new ArrayList<>();
	
	protected Usuario () {
		
	}
	
    public Usuario(String usuarioId, String password, String iBAN, boolean es_VIP) {
		super();
		this.usuarioId = usuarioId;
		this.password = password;
		IBAN = iBAN;
		this.es_VIP = es_VIP;
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
		this.series_finalizadas.addAll(series_finalizadas);
	}
	
    public List<SeriesVisualizada> getSeriesEmpezadas() {
        return series_empezadas;
    }
	
	public void setSeriesEmpezadas(List<SeriesVisualizada> series_empezadas) {
		this.series_empezadas = series_empezadas;
	}
	public void setNuevaSerieEmpezada(SeriesVisualizada serie_empezada) {
		int contador = 0;
		ArrayList<SeriesVisualizada> series_visualizadas = new ArrayList<>();
		series_visualizadas.addAll(this.series_empezadas);
		boolean existe = false;
		if(!series_visualizadas.isEmpty()) {
			for (SeriesVisualizada sv : series_visualizadas) {
				
				if(sv.getSerie().getNombre_serie().equals(serie_empezada.getSerie().getNombre_serie())) {
					series_visualizadas.get(contador).setUltimo_capitulo_visto(serie_empezada.getUltimo_capitulo_visto());
					existe = true;
				}
				++contador;
			}
		}else {
			series_visualizadas.add(serie_empezada);
		}
		
		if(!existe) {
			series_visualizadas.add(serie_empezada);
		}
		
		this.series_empezadas.clear();
		this.series_empezadas.addAll(series_visualizadas);
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
	
	public Boolean quitarSeriePendiente(Serie s) {
		if(this.series_pendientes.isEmpty()) {
			return false;
		}else {
			int contador = 0;
			for (Serie serie : this.series_pendientes) {
				if(s.getNombre_serie().equals(serie.getNombre_serie())) {
					this.series_pendientes.remove(contador);
					return true;
				}
				++contador;
			}
			return false;
		}
		
		
	}
	public Boolean quitarSerieEmpezada(Serie s) {
		
		if(this.series_empezadas.isEmpty()) {
			System.out.println("no estoy en empezadas");
			return false;
		}else { 
			int contador = 0;
			for (SeriesVisualizada serie : this.series_empezadas) {
				if(s.getNombre_serie().equals(serie.getSerie().getNombre_serie())) {
					
					this.series_empezadas.clear();//aqui esta la cuestión, parece que el remove no funciona, pero el clear,si (revisar mañana)
					System.out.println(this.series_empezadas.size()+") me van a eliminar" + s.getNombre_serie());
					return true;
				}
				++contador;
			}
			return false;
		}	
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

	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", password=" + password + ", IBAN=" + IBAN + ", es_VIP=" + es_VIP
				+ "]";
	}
    
	
}
