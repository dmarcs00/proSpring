package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.VO.Actor;
import com.example.VO.Creador;
import com.example.entity.Capitulo;
import com.example.entity.Categoria;
import com.example.entity.Serie;
import com.example.entity.Temporada;
import com.example.entity.Usuario;
import com.example.repository.SerieRepository;
import com.example.repository.UsuarioRepository;

@SpringBootApplication
public class ProyectoUcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoUcApplication.class);
		System.out.println("Hola mundo");
	}
	@Bean
	public CommandLineRunner demo(UsuarioRepository ur, SerieRepository sr) {
	    return (args) -> {
	    	
	    	/*Categoria normal = new Categoria(0.5, "Normal");
	    	Categoria silver = new Categoria(0.75, "Silver");
	    	Categoria gold = new Categoria(1.5, "Gold");*/
	    	//Usuarios
	    	ur.save(new Usuario("usr1", "pass", "12345678910", false));
	    	ur.save(new Usuario("usr2", "pass", "12345678911", false));
	    	ur.save(new Usuario("usr3", "pass", "12345678912", true));
	      
	    	//Series
	    	Serie s1 = new Serie("Serie1", "Descripcion de la serie 1", null);
	    	//Serie s2 = new Serie("Serie2", "Descripcion de la serie 2", silver);
	    	//Serie s3 = new Serie("Serie3", "Descripcion de la serie 1", gold);
	    	//actores
	    	Actor a1 = new Actor("David", "Marcos");
	    	Actor a2 = new Actor("Juan", "Otere");
	    	Actor a3 = new Actor("Ivar", "The boneless");
	    	Actor a4 = new Actor("Luke", "Cage");
	    	ArrayList<Actor> actores1 = new ArrayList<>();
	    	actores1.add(a1);
	    	actores1.add(a2);
	    	actores1.add(a3);
	    	ArrayList<Actor> actores2 = new ArrayList<>();
	    	actores2.add(a1);
	    	actores2.add(a3);
	    	actores2.add(a4);
	    	//creadores
	    	Creador cr1 = new Creador("Leyre", "Perez");
	    	Creador cr2 = new Creador("Raissa", "Gonzalez");
	    	Creador cr3 = new Creador("Mario", "Arce");
	    	Creador cr4 = new Creador("Samuel", "Casas");
	    	ArrayList<Creador> creadores1 = new ArrayList<>();
	    	creadores1.add(cr1);
	    	creadores1.add(cr4);
	    	ArrayList<Creador> creadores2 = new ArrayList<>();
	    	creadores2.add(cr2);
	    	creadores2.add(cr3);
	    	//Temporadas
	    	Temporada t1 = new Temporada(s1);
	    	Temporada t2 = new Temporada(s1);
	    	//Temporada t3 = new Temporada(s2);
	    	
	    	ArrayList<Temporada> temporadas1 = new ArrayList<>();
	    	temporadas1.add(t1);
	    	temporadas1.add(t2);	
	    	//ArrayList<Temporada> temporadas2 = new ArrayList<>();
	    	//temporadas2.add(t3);
	    	//Capitulos
	    	Capitulo c1 = new Capitulo("Comienzo", "https://netflix.com", "La introduccion a todo lo desconocido", t1);
	    	Capitulo c2 = new Capitulo("Nudo", "https://netflix.com", "El nudo a todo lo desconocido", t1);
	    	Capitulo c3 = new Capitulo("Desenlace", "https://netflix.com", "El desenlace a todo lo desconocido", t1);
	    	Capitulo c4 = new Capitulo("Final", "https://netflix.com", "El final a todo lo desconocido", t1);
	    	
	    	//Capitulo c5 = new Capitulo("Seriepelicula", "https://netflix.com", "Serie de un solo capitulo (pelicula de toda la vida)", t2);
	    	
	    	ArrayList<Capitulo> capitulos1 = new ArrayList<>();
	    	capitulos1.add(c1);
	    	capitulos1.add(c2);
	    	capitulos1.add(c3);
	    	capitulos1.add(c4);
	    	//ArrayList<Capitulo> capitulos2 = new ArrayList<>();
	    	//capitulos2.add(c5);
	    	
	    	t1.setCapitulos(capitulos1);
	    	//t2.setCapitulos(capitulos2);
	    	
	    	//Setter de series
	    	s1.setTemporada(temporadas1);
	    	//s2.setTemporada(temporadas2);
	    	s1.setCreadores(creadores1);
	    	s1.setActores(actores1);
	    	//Save de Series
	    	System.out.println(s1.toString());
	    	sr.save(s1);
	    	//sr.save(s2);
	    	//sr.save(s3);
	    };
	  }
	
}
