package com.example.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.entity.Serie;
import com.example.service.common.GenericServiceImpl;

@Service
public class SerieService extends GenericServiceImpl<Serie, Integer> {

	SerieRepository repository;
	@Override
	public JpaRepository<Serie, Integer> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	/**
	 * La utilidad de esto es que puedes implementar los metodos personaalizados del repositorio
	 * Tambien puedes realizar algunas comprobaciones antes de crear un registro, etc.
	 */
}
