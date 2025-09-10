package com.gbb.adminGastosApi.controller;

import java.time.LocalDateTime;
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
	
	@GetMapping("/health")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("OK");
	}

	// Info endpoint
	@GetMapping("/info")
	public ResponseEntity<Map<String, String>> info() {
		Map<String, String> info = new HashMap<>();
		info.put("status", "running");
		info.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(info);
	}
}