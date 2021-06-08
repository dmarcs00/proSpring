package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.VO.Actor;
import com.example.VO.Creador;
import com.example.entity.Capitulo;
import com.example.entity.CargoCapitulo;
import com.example.entity.Categoria;
import com.example.entity.Factura;
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
	@Transactional
	public CommandLineRunner demo(UsuarioRepository ur, SerieRepository sr) {
	    return (args) -> {
	    	
	    	//Categoria normal = new Categoria(0.5, "Normal");
	    	Categoria silver = new Categoria(0.75, "Silver");
	    	//Categoria gold = new Categoria(1.5, "Gold");
	    	//Usuarios
	    	Usuario usuario1 = new Usuario("usr1", "pass", "12345678910", false);
	    	
	    	
	    	//ur.save(new Usuario("usr2", "pass", "12345678911", false));
	    	//ur.save(new Usuario("usr3", "pass", "12345678912", true));
	      
	    	//Series
	    	Serie s1 = new Serie("Serie1", "Descripcion de la serie 1", silver);
	    	
	    	Temporada t1 = new Temporada(s1);
	    	Temporada t2 = new Temporada(s1);
	    	Temporada t3 = new Temporada(s1);
	    	
	    	Capitulo c1 = new Capitulo("Comienzo", "https://netflix.com", "La introduccion a todo lo desconocido", t3);
	    	Capitulo c2 = new Capitulo("Nudo", "https://netflix.com", "El nudo a todo lo desconocido", t3);
	    	Capitulo c3 = new Capitulo("Desenlace", "https://netflix.com", "El desenlace a todo lo desconocido", t3);
	    	Capitulo c4 = new Capitulo("Final", "https://netflix.com", "El final a todo lo desconocido", t3);
	    	
	    	ArrayList<Capitulo> capitulos1 = new ArrayList<>();
	    	capitulos1.add(c1);
	    	capitulos1.add(c2);
	    	capitulos1.add(c3);
	    	capitulos1.add(c4);
	    	t3.setCapitulos(capitulos1);
	    	ArrayList<Temporada> temporadas1 = new ArrayList<>();
	    	temporadas1.add(t1);
	    	temporadas1.add(t2);
	    	temporadas1.add(t3);
	    	s1.setTemporada(temporadas1);
	    
	    	sr.save(s1);
	    	List<Serie> series_finalizadas = new ArrayList<>();
	    	series_finalizadas.add(s1);
	    	//usuario1.setSeriesFinalizadas(series_finalizadas);
	    	//Serie s2 = new Serie("Serie2", "Descripcion de la serie 2", null);
	    	//Serie s3 = new Serie("Serie3", "Descripcion de la serie 1", null);
	    	//actores
	    	/*Actor a1 = new Actor("David", "Marcos");
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
	    	
	    	
	    	//series finalizadas
	    	ArrayList<Serie> series_finalizadas = new ArrayList<>();
	    	series_finalizadas.add(s1);
	    	usuario1.setSeriesFinalizadas(series_finalizadas);
	    	
	    	t1.setCapitulos(capitulos1);
	    	//t2.setCapitulos(capitulos2);
	    	
	    	//Setter de series
	    	s1.setTemporada(temporadas1);
	    	//s2.setTemporada(temporadas2);
	    	s1.setCreadores(creadores1);
	    	s1.setActores(actores1);
	    	//Save de Series
	    	System.out.println(s1.toString());*/
	    	/*ur.save(usuario1);
	    	sr.save(s1);*/
	    	ur.save(usuario1);
	    	//Facturas
	    	Factura f1 = new Factura("052021", usuario1);
	    	ArrayList<CargoCapitulo> capitulos_vistos = new ArrayList<>();
	    	CargoCapitulo cp1 = new CargoCapitulo(c1, "01/06/2021", f1);
	    	CargoCapitulo cp2 = new CargoCapitulo(c2, "02/06/2021", f1);
	    	CargoCapitulo cp3 = new CargoCapitulo(c3, "02/06/2021", f1);
	    	CargoCapitulo cp4 = new CargoCapitulo(c4, "03/05/2021", f1);
	    	CargoCapitulo cp5 = new CargoCapitulo(c1, "04/04/2021", f1);
	    	capitulos_vistos.add(cp1);
	    	capitulos_vistos.add(cp2);
	    	capitulos_vistos.add(cp3);
	    	capitulos_vistos.add(cp4);
	    	capitulos_vistos.add(cp5);
	    	f1.setCapitulos_vistos_factura(capitulos_vistos);
	    	ArrayList<Factura> facturas = new ArrayList<>();
	    	facturas.add(f1);
	    	usuario1.setFactura(facturas);
	    	
	    	
	    	ur.save(usuario1);
	    	//sr.save(s2);
	    	//sr.save(s3);
	    };
	  }
	
}