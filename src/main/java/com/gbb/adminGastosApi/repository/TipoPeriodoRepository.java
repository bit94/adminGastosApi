package com.gbb.adminGastosApi.repository;

import org.springframework.stereotype.Repository;

import com.gbb.adminGastosApi.model.TipoPeriodo;
import com.gbb.adminGastosApi.repository.base.CatalogoRepository;

@Repository
public interface TipoPeriodoRepository extends CatalogoRepository<TipoPeriodo, Long> {

}
