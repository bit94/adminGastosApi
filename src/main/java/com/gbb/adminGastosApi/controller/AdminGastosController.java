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
	
    // Health check personalizado
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", new Date().toString());
        response.put("service", "Admin Gastos API");
        return ResponseEntity.ok(response);
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