package com.gbb.adminGastosApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbb.adminGastosApi.dto.TipoPeriodoDTO;
import com.gbb.adminGastosApi.mapper.TipoPeriodoMapper;
import com.gbb.adminGastosApi.model.TipoPeriodo;
import com.gbb.adminGastosApi.service.TipoPeriodoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipo-periodo")
public class TipoPeriodoController {
	private final TipoPeriodoService service;
	private final TipoPeriodoMapper mapper;

	public TipoPeriodoController(TipoPeriodoService service, TipoPeriodoMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	public List<TipoPeriodoDTO> getAll() {
		return service.findAll().stream().map(mapper::toDTO).toList();
	}

	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<TipoPeriodoDTO> create(@Valid @RequestBody TipoPeriodoDTO dto) {
		TipoPeriodo entity = mapper.toEntity(dto);
		TipoPeriodo saved = service.save(entity);
		return ResponseEntity.ok(mapper.toDTO(saved));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<TipoPeriodoDTO> update(@PathVariable Long id, @Valid @RequestBody TipoPeriodoDTO dto) {
		TipoPeriodo entity = mapper.toEntity(dto);
		TipoPeriodo updated = service.update(id, entity);
		return ResponseEntity.ok(mapper.toDTO(updated));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}