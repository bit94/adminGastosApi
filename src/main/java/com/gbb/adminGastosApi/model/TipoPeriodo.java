package com.gbb.adminGastosApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.gbb.adminGastosApi.model.base.BaseEntity;

@Entity
@Table(name = "cTipoPeriodo")
@Data
@NoArgsConstructor
public class TipoPeriodo extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String descripcion;

	@Column(nullable = false)
	private int dias;

	@Column(nullable = false)
	private LocalDateTime fechaCreacion;

	@Column(nullable = false)
	private Boolean activo;

	@PrePersist
	protected void onCreate() {
		fechaCreacion = LocalDateTime.now();
		activo = true;
	}
}