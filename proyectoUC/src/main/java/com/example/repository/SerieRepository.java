package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
	
}
