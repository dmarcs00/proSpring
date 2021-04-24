package com.example.entity;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
@Entity
public class Factura {
	@Id
	private Integer num_factura;
	private Date fecha_factura;
	@OneToMany(mappedBy = "Factura")
	private List<CargoCapitulo> capitulos_vistos_factura = new ArrayList<>(); // todos los capitulos vistos por el usuario
	@ManyToOne
	private Usuario usuario;
	
	public Factura(Integer num_factura, Date fecha_factura, List<CargoCapitulo> capitulos_vistos_factura) {
		this.num_factura = num_factura;
		this.fecha_factura = fecha_factura;
		this.capitulos_vistos_factura = capitulos_vistos_factura;
	}
	
	public Factura() {}
	
    public List<CargoCapitulo> getCapitulosVistosFactura() {
        return this.capitulos_vistos_factura;
    }
	
	public Integer getNum_factura() {
		return num_factura;
	}
	public void setNum_factura(Integer num_factura) {
		this.num_factura = num_factura;
	}
	public Date getFecha_factura() {
		return fecha_factura;
	}
	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}
	public void setCapitulos_vistos_factura(List<CargoCapitulo> capitulos_vistos_factura) {
		this.capitulos_vistos_factura = capitulos_vistos_factura;
	}
	
	/**
	 * 
	 * @return un String con el año y el mes concatenado, veremos si sirve mas adelante...
	 */
	public String getAnioMes() {
		String retorno = "";
		Date fecha_temp = this.fecha_factura;
		Calendar calendario_temp = Calendar.getInstance();
		calendario_temp.setTime(fecha_temp);
		retorno = retorno.concat(Integer.toString(calendario_temp.MONTH)+"/"+Integer.toString(calendario_temp.YEAR)); // m/aaaa
		return retorno;
	}
	
	/**
	 * 
	 * @param usuario
	 * @return el precio final dado un usuario
	 */
	public Double getImporteTotal(Usuario usuario) {
		
		double precio_final = 20.0;
		List<CargoCapitulo> capitulos_mes = obtenerListacapitulosMes(this.fecha_factura);
		if(!usuario.isEs_VIP()) {
			precio_final = 0.0;
			for(CargoCapitulo cc : capitulos_mes) {
				precio_final += cc.getPrecio();
			}
		}
		return precio_final;
	}
	
	/**
	 * 
	 * @param fecha
	 * @return lista de capitulos dada una fecha
	 */
	public List<CargoCapitulo> obtenerListacapitulosMes(Date fecha) {
		List<CargoCapitulo> capitulos_mes = new ArrayList<>();
		
		for(CargoCapitulo cc : this.capitulos_vistos_factura) {
			if(fechasMismoMesAnio(fecha, cc.getFecha())) {
				capitulos_mes.add(cc);
			}
		}
		return capitulos_mes;
	}
		
	/**
	 * 
	 * @param fecha1 fecha de la que se quiere obtener una factura
	 * @param fecha2 las fechas del capitulo visto
	 * @return si dadas dos fechas estan en el mismo mes y año
	 */
	public boolean fechasMismoMesAnio(Date fecha1, Date fecha2) {
		
		Calendar calendario_temp1 = Calendar.getInstance();
		Calendar calendario_temp2 = Calendar.getInstance();
		calendario_temp1.setTime(fecha1);
		calendario_temp2.setTime(fecha2);
		
		//Si el mes y el año de ambas fechas es igual, entonces es el capitulo que buscamos (este metodo puede dejar de existir cuando se implemente la base de datos)
		if((calendario_temp1.MONTH == calendario_temp2.MONTH) &&  (calendario_temp1.YEAR == calendario_temp2.YEAR)){
			 return true;
		 }
		 return false;
	}
}
