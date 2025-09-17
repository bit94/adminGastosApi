package com.gbb.adminGastosApi.service;

import com.gbb.adminGastosApi.model.Rol;
import com.gbb.adminGastosApi.model.Usuario;
import com.gbb.adminGastosApi.repository.RolRepository;
import com.gbb.adminGastosApi.repository.UsuarioRepository;
import com.gbb.adminGastosApi.security.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder encoder;

	public String register(String email, String password, String nombre) {
		if (usuarioRepository.findByEmail(email).isPresent()) {
			throw new RuntimeException("Email ya registrado");
		}

		// Buscar el rol USER en la base de datos
		Rol rolUsuario = rolRepository.findByNombre("USER")
				.orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));

		// Crear el nuevo usuario
		Usuario usuario = new Usuario(null, email, encoder.encode(password), nombre, null, null);
		usuario.setRoles(List.of(rolUsuario));

		// Guardar en la base de datos
		usuarioRepository.save(usuario);

		// Construir claims con roles para el token
		Map<String, Object> claims = new HashMap<>();
		claims.put("roles", usuario.getRoles().stream().map(rol -> "ROLE_" + rol.getNombre().toUpperCase())
				.collect(Collectors.toList()));

		// Generar y devolver el token
		return jwtUtil.generateToken(claims, usuario.getEmail());
	}

	public ResponseEntity<String> login(String email, String password) {
		try {
			Usuario usuario = usuarioRepository.findByEmail(email)
					.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

			if (!encoder.matches(password, usuario.getPassword())) {
				return ResponseEntity.status(401).body("Contraseña incorrecta");
			}

			Map<String, Object> claims = new HashMap<>();
			claims.put("roles", usuario.getRoles().stream().map(role -> "ROLE_" + role.getNombre().toUpperCase())
					.collect(Collectors.toList()));
			String token = jwtUtil.generateToken(claims, usuario.getEmail());
			return ResponseEntity.ok(token);

		} catch (RuntimeException e) {
			return ResponseEntity.status(401).body(e.getMessage());
		}
	}
}
