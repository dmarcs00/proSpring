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
import com.example.entity.SeriesVisualizada;
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
	    	
	    	Categoria normal = new Categoria(0.5, "Normal");
	    	Categoria silver = new Categoria(0.75, "Silver");
	    	Categoria gold = new Categoria(1.5, "Gold");
	    	//Usuarios
	    	Usuario usuario1 = new Usuario("usr1", "aaaa", "12345678910", true);
	    	
	    	
	    	//ur.save(new Usuario("usr2", "pass", "12345678911", false));
	    	//ur.save(new Usuario("usr3", "pass", "12345678912", true));
	      
	    	//Series
	    	Serie s1 = new Serie("Serie1", "Descripcion de la serie 1", silver);
	    	
	    	Temporada t1 = new Temporada(s1);
	    	Temporada t2 = new Temporada(s1);
	    	Temporada t3 = new Temporada(s1);
	    	
	    	Capitulo c1 = new Capitulo("Comienzot2", "https://netflix.com", "La introduccion a todo lo desconocido", t2);
	    	Capitulo c2 = new Capitulo("Nudot2", "https://netflix.com", "El nudo a todo lo desconocido", t2);
	    	Capitulo c3 = new Capitulo("Desenlacet3", "https://netflix.com", "El desenlace a todo lo desconocido", t3);
	    	Capitulo c4 = new Capitulo("Finalt3", "https://netflix.com", "El final a todo lo desconocido", t3);
	    	
	    	Capitulo c11 = new Capitulo("Comienzot1", "https://netflix.com", "La introduccion a todo lo desconocido", t1);
	    	Capitulo c12 = new Capitulo("Nudot1", "https://netflix.com", "El nudo a todo lo desconocido", t1);
	    	Capitulo c13 = new Capitulo("Desenlacet1", "https://netflix.com", "El desenlace a todo lo desconocido", t1);
	    	Capitulo c14 = new Capitulo("Finalt1", "https://netflix.com", "El final a todo lo desconocido", t1);
	    	
	    	ArrayList<Capitulo> capitulos1 = new ArrayList<>();
	    	capitulos1.add(c11);
	    	capitulos1.add(c12);
	    	capitulos1.add(c13);
	    	capitulos1.add(c14);
	    	//t1.setCapitulos(capitulos1);
	    	t1.getCapitulos().add(c11);
	    	t1.getCapitulos().add(c12);
	    	t1.getCapitulos().add(c13);
	    	t1.getCapitulos().add(c14);
	 
	    	ArrayList<Capitulo> capitulos2 = new ArrayList<>();
	    	capitulos2.add(c1);;
	    	capitulos2.add(c2);
	    	t2.setCapitulos(capitulos2);
	    	ArrayList<Capitulo> capitulos3 = new ArrayList<>();
	    	capitulos3.add(c3);
	    	capitulos3.add(c4);
	    	t3.setCapitulos(capitulos3);
	    	ArrayList<Temporada> temporadas1 = new ArrayList<>();
	    	temporadas1.add(t1);
	    	temporadas1.add(t2);
	    	temporadas1.add(t3);
	    	s1.setTemporada(temporadas1);
	    
	    	
	    	Serie s2 = new Serie("Serie2", "Descripcion de la serie 2", gold);
	    	Temporada t21 = new Temporada(s2);
	    	Capitulo c21 = new Capitulo("Comienzo2", "https://netflix.com", "La introduccion a todo lo desconocido serie2", t21);
	    	Capitulo c22 = new Capitulo("Nudo2", "https://netflix.com", "El nudo a todo lo desconocido serie2", t21);
	    	Capitulo c23 = new Capitulo("Desenlace2", "https://netflix.com", "El desenlace a todo lo desconocido serie2", t21);
	    	Capitulo c24 = new Capitulo("Final2", "https://netflix.com", "El final a todo lo desconocido serie2", t21);
	    	ArrayList<Capitulo> capitulos21 = new ArrayList<>();
	    	capitulos21.add(c21);
	    	capitulos21.add(c22);
	    	capitulos21.add(c23);
	    	capitulos21.add(c24);
	    	t21.setCapitulos(capitulos21);
	    	ArrayList<Temporada> temporadas21 = new ArrayList<>();
	    	temporadas21.add(t21);
	    	s2.setTemporada(temporadas21);
	    	sr.save(s1);
	    	sr.save(s2);
	    	List<Serie> series_finalizadas = new ArrayList<>();
	    	List<Serie> series_pendientes = new ArrayList<>();
	    	series_finalizadas.add(s2);
	    	series_pendientes.add(s1);
	    	usuario1.setSeriesFinalizadas(series_finalizadas);
	    	usuario1.setSeriesPendientes(series_pendientes);
	    	
	    	Serie s3 = new Serie("Serie3", "Descripcion de la serie 3", new Categoria(0.75, "silver"));
	    	
	    	Temporada t31 = new Temporada(s3);
	    	Temporada t32 = new Temporada(s3);
	    	
	    	Capitulo c31 = new Capitulo("Comienzot31", "https://netflix.com", "La introduccion a todo lo desconocido", t31);
	    	Capitulo c32 = new Capitulo("Nudot31", "https://netflix.com", "El nudo a todo lo desconocido", t31);
	    	Capitulo c33 = new Capitulo("Desenlacet31", "https://netflix.com", "El desenlace a todo lo desconocido", t31);
	    	Capitulo c34 = new Capitulo("Finalt31", "https://netflix.com", "El final a todo lo desconocido", t31);
	    	
	    	Capitulo c321 = new Capitulo("Comienzot32", "https://netflix.com", "La introduccion a todo lo desconocido", t32);
	    	Capitulo c322 = new Capitulo("Nudot32", "https://netflix.com", "El nudo a todo lo desconocido", t32);
	    	Capitulo c323 = new Capitulo("Desenlacet32", "https://netflix.com", "El desenlace a todo lo desconocido", t32);
	    	Capitulo c324 = new Capitulo("Finalt32", "https://netflix.com", "El final a todo lo desconocido", t32);
	    	
	    	ArrayList<Capitulo> capitulos31 = new ArrayList<>();
	    	capitulos31.add(c31);
	    	capitulos31.add(c32);
	    	capitulos31.add(c33);
	    	capitulos31.add(c34);
	    	
	    	ArrayList<Capitulo> capitulos32 = new ArrayList<>();
	    	capitulos32.add(c321);
	    	capitulos32.add(c322);
	    	capitulos32.add(c323);
	    	capitulos32.add(c324);
	    	
	    	t31.setCapitulos(capitulos31);
	    	t32.setCapitulos(capitulos32);
	    	ArrayList<Temporada> temporadas3 = new ArrayList<>();
	    	temporadas3.add(t31);
	    	temporadas3.add(t32);
	    	s3.setTemporada(temporadas3);
	    	sr.save(s3);
	    	
	    	SeriesVisualizada sv1 = new SeriesVisualizada(usuario1, 5, s3);
	    	
	    	ArrayList<SeriesVisualizada> svs = new ArrayList<>(); 
	    	svs.add(sv1);
	    	usuario1.setSeriesEmpezadas(svs);
	    	
	    	System.out.println(usuario1.getSeriesEmpezadas().size());
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
	  
	    	//Facturas
	    	Factura f1 = new Factura("052021", usuario1);
	    	ArrayList<CargoCapitulo> capitulos_vistos = new ArrayList<>();
	    	CargoCapitulo cp1 = new CargoCapitulo(c1, "01/05/2021", f1);
	    	CargoCapitulo cp2 = new CargoCapitulo(c2, "02/05/2021", f1);
	    	CargoCapitulo cp3 = new CargoCapitulo(c3, "12/05/2021", f1);
	    	CargoCapitulo cp4 = new CargoCapitulo(c4, "03/05/2021", f1);
	    	CargoCapitulo cp5 = new CargoCapitulo(c1, "04/05/2021", f1);
	    	capitulos_vistos.add(cp1);
	    	capitulos_vistos.add(cp2);
	    	capitulos_vistos.add(cp3);
	    	capitulos_vistos.add(cp4);
	    	capitulos_vistos.add(cp5);
	    	f1.setCapitulos_vistos_factura(capitulos_vistos);
	    	
	    	Factura f2 = new Factura("062021", usuario1);
	    	ArrayList<CargoCapitulo> capitulos_vistos2 = new ArrayList<>();
	    	CargoCapitulo cp6 = new CargoCapitulo(c1, "01/06/2021", f2);
	    	CargoCapitulo cp7 = new CargoCapitulo(c2, "02/06/2021", f2);
	    	CargoCapitulo cp8 = new CargoCapitulo(c3, "12/06/2021", f2);
	    	CargoCapitulo cp9 = new CargoCapitulo(c4, "03/06/2021", f2);
	    	CargoCapitulo cp10 = new CargoCapitulo(c1, "04/06/2021", f2);
	    	CargoCapitulo cp11 = new CargoCapitulo(c4, "15/06/2021", f2);
	    	CargoCapitulo cp12 = new CargoCapitulo(c1, "24/06/2021", f2);
	    	capitulos_vistos2.add(cp6);
	    	capitulos_vistos2.add(cp7);
	    	capitulos_vistos2.add(cp8);
	    	capitulos_vistos2.add(cp9);
	    	capitulos_vistos2.add(cp10);
	    	capitulos_vistos2.add(cp11);
	    	capitulos_vistos2.add(cp12);
	    	f2.setCapitulos_vistos_factura(capitulos_vistos2);
	    	ArrayList<Factura> facturas = new ArrayList<>();
	    	facturas.add(f1);
	    	facturas.add(f2);
	    	usuario1.setFactura(facturas);
	    	
	    	ur.save(usuario1);
	    	//sr.save(s2);
	    	//sr.save(s3);
	    };
	  }
	
}
