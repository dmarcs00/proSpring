package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
	
	//@Query("SELECT sf FROM USUARIO_SERIES_FINALIZADAS sf WHERE sf.USUARIO_USUARIO_ID = ?1")
	//public List<Serie> findByUsuarioId(String usuarioId);
	
}
