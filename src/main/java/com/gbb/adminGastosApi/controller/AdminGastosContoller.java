package com.gbb.adminGastosApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminGastosContoller {
	@GetMapping("/saludo")
	public String saludo() {
		return "¡Hola desde el backend!";
	}
}