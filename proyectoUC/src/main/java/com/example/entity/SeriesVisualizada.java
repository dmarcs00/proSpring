package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SeriesVisualizada {

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Usuario usuario;
}
