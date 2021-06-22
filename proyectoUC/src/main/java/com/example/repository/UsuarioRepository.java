package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	//@Query("SELECT sf FROM USUARIO_SERIES_FINALIZADAS sf WHERE sf.USUARIO_USUARIO_ID = ?1")
	
}
