package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.entity.Serie;
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
	
	public Usuario aniadirserieEmpezada(String serieId, String userId){
		
		Usuario result = null;
		/*
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
		
			Usuario u = em.find(Usuario.class, userId);
			
			if (u != null) {
				
				Serie s = em.find(Serie.class,userId);
				
				if (user != null) {
					result = v.aceptarUsuario(user)?v:null;
				} else {
					throw new ResourceNotFound();
				} 
			} else {
				throw new ResourceNotFound();
			}
			
			em.getTransaction().commit();

		} catch(Exception e) {
			em.getTransaction().rollback();
			throw e;
		} */
		
		return result;
	}
	
	@Override
	public UsuarioRepository getRepository() {
		// TODO Auto-generated method stub
		return ur;
	}

}
