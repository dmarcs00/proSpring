package com.example.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
	//aqui se pueden definir aquellos metodos personalizables definidos por el propio JPA para la logica de negocio de la app
}
