package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.entity.Serie;
import com.example.entity.Usuario;
import com.example.repository.SerieRepository;
import com.example.service.common.GenericServiceImpl;

@Service
public class SerieService extends GenericServiceImpl<Serie, Integer> {

	@Autowired
	SerieRepository sr;
	
	@Override
	public JpaRepository<Serie, Integer> getRepository() {
		// TODO Auto-generated method stub
		return sr;
	}
	/**
	 * Para la vista de agregar serie se utilizará este método.
	 * @param serieId
	 * @return
	 */
	public Optional<Serie> findById(Integer serieId) {
		return sr.findById(serieId);
	}
	
	public List<Serie> findAll() {
		return sr.findAll();
	}
	
}
