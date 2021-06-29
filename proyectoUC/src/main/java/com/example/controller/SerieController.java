package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Serie;
import com.example.entity.Usuario;
import com.example.service.impl.SerieService;
import com.example.views.View.DescripcionSerie;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/series")
public class SerieController {

	@Autowired
	SerieService ss;
	
	@GetMapping(value="/agregar-serie")
	@JsonView(DescripcionSerie.class)
	public ResponseEntity<List<Serie>> obtenerTodosUsuarios() {
		
		List<Serie> series = ss.findAll();
		ResponseEntity<List<Serie>> result;
		if (series != null) {
			result = ResponseEntity.ok(series);
		} else { 
			result = ResponseEntity.notFound().build();
		}

		return result; 	
	}
	
}
