package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.entity.Usuario;
import com.example.repository.UsuarioRepository;

@SpringBootApplication
public class ProyectoUcApplication {

	private static final Logger log = LoggerFactory.getLogger(ProyectoUcApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoUcApplication.class);
		System.out.println("Hola mundo");
	}
	@Bean
	public CommandLineRunner demo(UsuarioRepository repository) {
	    return (args) -> {
	      // save a few customers
	      //repository.save(new Customer("Jack", "Bauer"));
	      // fetch all customers
	      /*log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (Customer customer : repository.findAll()) {
	        log.info(customer.toString());
	      }
	      log.info("");

	      // fetch an individual customer by ID
	      Customer customer = repository.findById(1L);
	      log.info("Customer found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(customer.toString());
	      log.info("");

	      // fetch customers by last name
	      log.info("Customer found with findByLastName('Bauer'):");
	      log.info("--------------------------------------------");
	      repository.findByLastName("Bauer").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      // for (Customer bauer : repository.findByLastName("Bauer")) {
	      //  log.info(bauer.toString());
	      // }
	      log.info("");*/
	    };
	  }
	
}
