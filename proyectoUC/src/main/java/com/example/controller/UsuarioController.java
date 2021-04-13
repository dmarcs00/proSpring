package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.service.impl.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
}
