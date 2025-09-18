package com.gbb.adminGastosApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gbb.adminGastosApi.dto.TipoPeriodoDTO;
import com.gbb.adminGastosApi.mapper.TipoPeriodoMapper;
import com.gbb.adminGastosApi.model.TipoPeriodo;
import com.gbb.adminGastosApi.repository.TipoPeriodoRepository;
import com.gbb.adminGastosApi.service.base.CatalogoService;

@Service
public class TipoPeriodoService extends CatalogoService<TipoPeriodo> {
	@Autowired
	private TipoPeriodoMapper mapper;
	
	public TipoPeriodoService(TipoPeriodoRepository repository) {
		super(repository);
	}

	@Override
	public TipoPeriodo update(Long id, TipoPeriodo incoming) {
	    TipoPeriodo existing = repository.findById(id)
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el catálogo con ID: " + id));

	    TipoPeriodoDTO dto = mapper.toDTO(incoming);
	    mapper.mergeDtoIntoEntity(dto, existing);

	    return repository.save(existing);
	}
}