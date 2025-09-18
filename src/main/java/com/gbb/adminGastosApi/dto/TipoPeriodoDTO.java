package com.gbb.adminGastosApi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoPeriodoDTO {
	@NotBlank(message = "La descripción no puede estar vacía.")
	private String Descripcion;

	@Min(value = 1, message = "Los días deben ser al menos 1.")
	@Max(value = 365, message = "No puede exceder un año.")
	private int Dias;
}
