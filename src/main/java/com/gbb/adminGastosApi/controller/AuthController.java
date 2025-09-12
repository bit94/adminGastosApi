package com.gbb.adminGastosApi.controller;

import com.gbb.adminGastosApi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public String register(@RequestParam String email, @RequestParam String password, @RequestParam String nombre) {
		return authService.register(email, password, nombre);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
		return authService.login(email, password);
	}
}
