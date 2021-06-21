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
					SeriesVisualizada sv = new SeriesVisualizada(u,capitulos_vistos,s);
					System.out.println("hola2");
					u.setNuevaSerieEmpezada(sv);
					System.out.println("hola3");
					u.quitarSeriePendiente(s);
					result = u;
				} else {
					throw new NotFoundException();
				} 
			} else {
				throw new NotFoundException();
			}
			
			em.getTransaction().commit();

		} catch(Exception e) {
			em.getTransaction().rollback();
			throw e;
		} 
		System.out.println(result);
		return result;
	}
	
	@Override
	public UsuarioRepository getRepository() {
		// TODO Auto-generated method stub
		return ur;
	}

}
