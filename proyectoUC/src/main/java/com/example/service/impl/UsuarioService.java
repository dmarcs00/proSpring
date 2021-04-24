package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.entity.Usuario;
import com.example.repository.UsuarioRepository;
import com.example.service.common.GenericServiceImpl;

@Service
public class UsuarioService extends GenericServiceImpl<Usuario, String> {
	
	@Autowired
	UsuarioRepository repository;
	
	@Override
	public UsuarioRepository getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
