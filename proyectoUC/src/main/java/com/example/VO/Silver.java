package com.example.VO;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.example.entity.Categoria;

@Embeddable
public class Silver extends Categoria {

	protected static double precio = 0.75;
	
	public Silver() {
		super(precio);
	}
}
