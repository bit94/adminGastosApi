package com.gbb.adminGastosApi.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminGastosController {
	@GetMapping("/saludo")
	public String saludo() {
		System.out.println("Request /saludo");
		return "¡Hola desde el backend!";
	}

	// HEALTH CHECK MUY SIMPLE
	@GetMapping("/health")
	public String health() {
		return "OK";
	}

	// Endpoint adicional para testing
	@GetMapping("/test")
	public Map<String, String> test() {
		Map<String, String> response = new HashMap<>();
		response.put("status", "running");
		response.put("port", System.getProperty("server.port"));
		return response;
	}
}