package com.gbb.adminGastosApi.security;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JwtUtil {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 86400000; // 24 horas en milisegundos

    // Genera token con claims personalizados (roles, etc.)
    public String generateToken(Map<String, Object> claims, String email) {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact();
    }

    // Extrae el email (subject) del token
    public String validateToken(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Extrae todos los claims del token
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    // Extrae los roles como authorities para Spring Security
    public List<GrantedAuthority> getAuthoritiesFromToken(String token) {
        List<String> roles = extractAllClaims(token).get("roles", List.class);
        return roles.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    }
}