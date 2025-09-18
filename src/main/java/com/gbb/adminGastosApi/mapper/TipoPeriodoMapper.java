package com.gbb.adminGastosApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.gbb.adminGastosApi.dto.TipoPeriodoDTO;
import com.gbb.adminGastosApi.model.TipoPeriodo;

@Mapper(componentModel = "spring")
public interface TipoPeriodoMapper {
	TipoPeriodoMapper INSTANCE = Mappers.getMapper(TipoPeriodoMapper.class);

	@Mapping(source = "descripcion", target = "Descripcion")
	TipoPeriodo toEntity(TipoPeriodoDTO dto);

	@Mapping(source = "Descripcion", target = "descripcion")
	TipoPeriodoDTO toDTO(TipoPeriodo entity);
}