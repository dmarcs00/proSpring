package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Factura;
import com.example.entity.Usuario;
import com.example.service.impl.UsuarioService;
import com.example.views.View.DescripcionUsuario;
import com.fasterxml.jackson.annotation.JsonView;



@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService us;
	
	@GetMapping(value="/{id}")
	@JsonView({DescripcionUsuario.class})
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
	
	@PutMapping("/usr1/ver-capitulo-{capitulos_vistos}/{numero_serie}")
	@JsonView(DescripcionUsuario.class)
	public ResponseEntity<Usuario> verCapitulo(@PathVariable("numero_serie") Integer numero_serie, @PathVariable("capitulos_vistos") int capitulos_vistos ) throws NotFoundException {
		
		ResponseEntity<Usuario> result = null;
		System.out.println("Capitulos vistos:"+ capitulos_vistos+" de la serie "+numero_serie);
		Usuario u = us.aniadirserieEmpezada("usr1", numero_serie, capitulos_vistos);
		if (u != null) {
			System.out.println("respuesta buena"+u);
			result = ResponseEntity.ok(u);
		} else {
			result = new ResponseEntity<Usuario>(HttpStatus.FORBIDDEN);
		}
		
		return result;
	}
	
	
	/*@GetMapping(value="/{id}/facturas")  No HACE FALTA YA QUE LAS PODEMOS SACAR DE USUARIO
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
	}*/
}
