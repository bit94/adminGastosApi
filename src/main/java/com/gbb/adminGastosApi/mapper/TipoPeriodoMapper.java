package com.gbb.adminGastosApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gbb.adminGastosApi.dto.TipoPeriodoDTO;
import com.gbb.adminGastosApi.model.TipoPeriodo;

@Mapper(componentModel = "spring")
public interface TipoPeriodoMapper {
	TipoPeriodoMapper INSTANCE = Mappers.getMapper(TipoPeriodoMapper.class);

	TipoPeriodo toEntity(TipoPeriodoDTO dto);

	TipoPeriodoDTO toDTO(TipoPeriodo entity);
}