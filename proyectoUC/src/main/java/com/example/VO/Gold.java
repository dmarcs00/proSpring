package com.example.VO;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.example.entity.Categoria;

@Embeddable
public class Gold extends Categoria {

	protected static double precio = 1.5;
	
	public Gold() {
		super(precio);
	}
}
