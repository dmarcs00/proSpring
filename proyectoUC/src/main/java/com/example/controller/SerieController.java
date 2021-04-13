package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.service.impl.SerieService;

@Controller
public class SerieController {

	@Autowired
	SerieService serieService;
	
}
