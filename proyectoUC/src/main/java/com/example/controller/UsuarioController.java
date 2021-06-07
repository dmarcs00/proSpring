package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Factura;
import com.example.entity.Usuario;
import com.example.service.impl.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService us;
	
	@GetMapping(value="/{id}")
	//@JsonView(Views.DescripcionUsuario.class)
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") String userId) {
		
		Optional<Usuario> u = us.findById(userId);
		ResponseEntity<Usuario> result;
		if (u.isPresent()) {
			result = ResponseEntity.ok(u.get());
		} else { 
			System.out.println("hola");
			result = ResponseEntity.notFound().build();
		}
		System.out.println(u);
		return result; 	
	}
	
	@GetMapping(value="/")
	//@JsonView(Views.DescripcionUsuario.class)
	public ResponseEntity<List<Usuario>> obtenerTodosUsuarios() {
		
		List<Usuario> usuarios = us.findAll();
		ResponseEntity<List<Usuario>> result;
		if (usuarios != null) {
			result = ResponseEntity.ok(usuarios);
		} else { 
			result = ResponseEntity.notFound().build();
		}

		return result; 	
	}
	
	@GetMapping(value="/{id}/facturas")
	//@JsonView(Views.DescripcionUsuario.class)
	public ResponseEntity<List<Factura>> obtenerFacturas(@PathVariable("id") String userId) {
		
		Optional<Usuario> u = us.findById(userId);
		List<Factura> facturas = null;
		ResponseEntity<List<Factura>> result;
		
		if (u.isPresent()) {
			facturas = u.get().getFactura();
			if (facturas != null) {
				result = ResponseEntity.ok(facturas);	
			} else { 
				result = ResponseEntity.notFound().build();	
			}
		} else {
			result = ResponseEntity.notFound().build();
		}
		
		return result; 	
	}
}
