package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

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
						u.quitarSerieEmpezada(s);
						
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

}
