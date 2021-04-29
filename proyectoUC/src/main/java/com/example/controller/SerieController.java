package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.impl.SerieService;

@RestController
@RequestMapping("/series")
public class SerieController {

	@Autowired
	SerieService serieService;
	
}
