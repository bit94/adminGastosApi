package com.gbb.adminGastosApi.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.gbb.adminGastosApi.model.base.BaseEntity;

public abstract class CatalogoService<T extends BaseEntity> {
	protected final JpaRepository<T, Long> repository;

	public CatalogoService(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public Optional<T> findById(Long id) {
		return repository.findById(id);
	}

	public T save(T identity) {
		return repository.save(identity);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public T update(Long id, T entity) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el catálogo con ID: " + id);
		}

		// Asegura que el ID del path prevalezca
		if (entity instanceof BaseEntity) {
			((BaseEntity) entity).setId(id);
		}

		return repository.save(entity);
	}
}