package com.gbb.adminGastosApi.service;

import org.springframework.stereotype.Service;

import com.gbb.adminGastosApi.model.TipoPeriodo;
import com.gbb.adminGastosApi.repository.TipoPeriodoRepository;
import com.gbb.adminGastosApi.service.base.CatalogoService;

@Service
public class TipoPeriodoService extends CatalogoService<TipoPeriodo> {
	public TipoPeriodoService(TipoPeriodoRepository repository) {
		super(repository);
	}
}