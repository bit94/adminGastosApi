package com.gbb.adminGastosApi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoPeriodoDTO {
	@NotBlank(message = "La descripción no puede estar vacía.")
	private String descripcion;

	@Min(value = 1, message = "Los días deben ser al menos 1.")
	private int dias;
}
