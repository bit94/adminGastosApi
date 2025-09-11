package com.gbb.adminGastosApi.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JwtUtil {
	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final long expiration = 8640000;

	public String generateToken(String email) {
		return Jwts.builder().setSubject(email).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration)).signWith(key).compact();
	}

	public String validateToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}
}
