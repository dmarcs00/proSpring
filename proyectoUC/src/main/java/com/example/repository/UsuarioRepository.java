package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	//aqui se pueden definir aquellos metodos personalizables definidos por el propio JPA para la logica de negocio de la app
}
