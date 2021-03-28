package com.example.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.entity.Factura;
import com.example.service.common.GenericServiceImpl;

@Service
public class FacturaService extends GenericServiceImpl<Factura, Integer> {

	//queda saber si factura puede tener un repository
	@Override
	public JpaRepository<Factura, Integer> getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

}
