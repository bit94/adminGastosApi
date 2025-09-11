package com.gbb.adminGastosApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/api/test")
	public String testEndpoint() {
		return "✅ El servicio está activo y funcionando con PostgreSQL y Java 24";
	}
}