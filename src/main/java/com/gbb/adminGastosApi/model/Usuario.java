package com.gbb.adminGastosApi.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cUsuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String nombre;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "activo")
	private Boolean activo;

	// Pre-persist para setear fecha automáticamente
	@PrePersist
	protected void onCreate() {
		fechaCreacion = LocalDateTime.now();
		activo = true;
	}
}