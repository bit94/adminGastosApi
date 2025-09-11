package com.gbb.adminGastosApi.service;

import com.gbb.adminGastosApi.model.Usuario;
import com.gbb.adminGastosApi.repository.UsuarioRepository;
import com.gbb.adminGastosApi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private JwtUtil jwtUtil;

	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public String register(String email, String password, String nombre) {
		if (usuarioRepository.findByEmail(email).isPresent()) {
			throw new RuntimeException("Email ya registrado");
		}

		Usuario usuario = new Usuario(null, email, encoder.encode(password), nombre, null, null);
		usuarioRepository.save(usuario);

		return jwtUtil.generateToken(email);
	}

	public String login(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		if (!encoder.matches(password, usuario.getPassword())) {
			throw new RuntimeException("Contraseña incorrecta");
		}

		return jwtUtil.generateToken(email);
	}
}
