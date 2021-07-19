package com.example.service.impl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Capitulo;
import com.example.entity.CargoCapitulo;
import com.example.entity.Factura;
import com.example.entity.Serie;
import com.example.entity.SeriesVisualizada;
import com.example.entity.Temporada;
import com.example.entity.Usuario;
import com.example.repository.UsuarioRepository;
import com.example.service.common.GenericServiceImpl;


@Service
public class UsuarioService extends GenericServiceImpl<Usuario, String> {
	
	@Autowired
	UsuarioRepository ur;
	@PersistenceUnit
	EntityManagerFactory emf;

	public Optional<Usuario> findById(String usuarioId) {
		return ur.findById(usuarioId);
	}
	
	public List<Usuario> findAll() {
		return ur.findAll();
	}
	public Usuario save(Usuario u) {
		return ur.save(u);
	}
	
	/**
	 * Recoloca la serie en otra de las listas del usuario, ya sea en empezada o finalizada y la 
	 * quita de la lista de series pendientes.
	 * @param user_id
	 * @param numero_serie
	 * @param capitulos_vistos
	 * @return
	 * @throws NotFoundException
	 */
	public Usuario aniadirserieEmpezada(String user_id, Integer numero_serie, int capitulos_vistos) throws NotFoundException{
		Usuario result = null;
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
		
			Usuario u = em.find(Usuario.class, user_id);
			
			if (u != null) {
				
				Serie s = em.find(Serie.class,numero_serie);
				System.out.println("hola1"+s);
				
				if (s != null) {
					//comprobamos si la serie está finalizada o no para saber donde añadirla
					if(esSerieFinalizada(s, capitulos_vistos)) {
						//si no esta en series empezadas, entonces se quita de series pendientes(significa que se ha visto el ultimo capitulo
						if(!u.quitarSerieEmpezada(s)) {
							System.out.println("me van a quitar de pendientes");
							u.quitarSeriePendiente(s);
						}
						System.out.println(u.getSeriesEmpezadas().size());
						ArrayList<Serie> series_finalizadas = new ArrayList<>();
						series_finalizadas.add(s);
						u.setSeriesFinalizadas(series_finalizadas);
						
					}else {
						SeriesVisualizada sv = new SeriesVisualizada(u,capitulos_vistos,s);
						System.out.println("hola2");
						u.setNuevaSerieEmpezada(sv);
						System.out.println("hola3");
						u.quitarSeriePendiente(s);						
					}
					
					result = u;
				} else {
					throw new NotFoundException();
				} 
			} else {
				throw new NotFoundException();
			}
			
			em.getTransaction().commit();

		} catch(NotFoundException e) {
			em.getTransaction().rollback();
			throw e;
		} 
		System.out.println(result);
		return result;
	}
	
	public Factura facturarCapitulo(String user_id, int numero_serie, int capitulos_vistos) throws NotFoundException {
		
		//Obtenemos el mes y año en el que estamos
		Calendar fecha = Calendar.getInstance();
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int anio = fecha.get(Calendar.YEAR);
		//pasamos ambos a texto para poder obtener el ID de la factura
		String diaS = Integer.toString(dia);
		String mesS = Integer.toString(mes);
		String anioS = Integer.toString(anio);
		
		String factura_id = "";
		if(dia < 10) {
			diaS = "0"+diaS;
		}
		if(mes < 10) {
			mesS = "0"+mesS;
			factura_id = mesS+anioS;
		}else {
			factura_id = mesS+anioS;
		}
		
		Factura result = null;
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
			Usuario u = em.find(Usuario.class, user_id);
			if (u != null) {
				System.out.println(u.getFactura());
				Serie s = em.find(Serie.class,numero_serie);
				if(s != null) {
					//Se obtiene el capitulo en cuestión para añadirlo al cargo
					Capitulo c = this.getCapituloVisto(s, capitulos_vistos);
					Factura f = em.find(Factura.class, factura_id);
					List<Factura> fs = new ArrayList<>();
					//si es != null entonces no tenemos que crear la factura, solo añadir el capitulo a la factura existente. 
					//Si es null hay que crearla
					if(f != null) {
						CargoCapitulo cc = new CargoCapitulo(c, diaS + "/" + (mesS) + "/" + anioS, f);
						f.getCapitulosVistosFactura().add(cc);
						System.out.println("Me han añadido a una factura existente");
						result = f;
					}else {
						Factura factura_nueva = new Factura(mesS+anioS, u);
						CargoCapitulo cc = new CargoCapitulo(c, diaS + "/" + (mesS) + "/" + anioS, factura_nueva);
						factura_nueva.getCapitulosVistosFactura().add(cc);
						u.setNuevaFactura(factura_nueva);
						System.out.println("Me han añadido a una factura NUEVA");
						result = factura_nueva;
					}
				}else {
					throw new NotFoundException();
				}
			}else {
				throw new NotFoundException();
			}
			em.getTransaction().commit();
			
		} catch (NotFoundException e) {
			em.getTransaction().rollback();
			throw e;
		}

		return result;
	}
	
	private Capitulo getCapituloVisto(Serie s, int capitulos_vistos) {
		
		List<Temporada> temporadas = s.getTemporadas();
		int contador = 0;
		
		for(int i=0;i<temporadas.size();i++) {
			for(int j=0; j<temporadas.get(i).getCapitulos().size();j++) {
				
				if(++contador == capitulos_vistos) {
					return temporadas.get(i).getCapitulos().get(j);
				}
			}
		}
		return null;		
	}

	private boolean esSerieFinalizada(Serie serie, int capitulos_vistos) {
		int capitulos_serie = 0;
		for (Temporada t : serie.getTemporadas()) {
			capitulos_serie += t.getCapitulos().size();
		}
		if(capitulos_vistos == capitulos_serie) {
			return true;
		}
		return false;
	}
	
	@Override
	public UsuarioRepository getRepository() {
		// TODO Auto-generated method stub
		return ur;
	}

	public boolean existeSeriePendiente(Serie serie, Usuario u) {
		// TODO Auto-generated method stub
		ArrayList<Serie> series = new ArrayList<>();
		series.addAll(u.getSeriesPendientes());
		
		for (Serie s : series) {
			if(s.equals(serie)) {
				return true;
			}
			
		}
		return false;
	}
}
