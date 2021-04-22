package com.example.VO;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.example.entity.Categoria;

@Embeddable
public class Normal extends Categoria {

	protected static double precio = 0.5;
	
	public Normal() {
		super(precio);
	}
}
