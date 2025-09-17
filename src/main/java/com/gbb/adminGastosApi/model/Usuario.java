package com.gbb.adminGastosApi.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cUsuarios")
@Data
@NoArgsConstructor
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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	    name = "usuario_roles",
	    joinColumns = @JoinColumn(name = "usuario_id"),
	    inverseJoinColumns = @JoinColumn(name = "rol_id")
	)
	private List<Rol> roles;

	// Pre-persist para setear fecha automáticamente
	@PrePersist
	protected void onCreate() {
		fechaCreacion = LocalDateTime.now();
		activo = true;
	}

	public Usuario(Long id, String email, String password, String nombre, LocalDateTime fechaCreacion, Boolean activo) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}

	public String getPassword() {
		return password;
	}
}