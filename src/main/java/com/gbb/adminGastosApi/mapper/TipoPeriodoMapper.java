package com.gbb.adminGastosApi.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.gbb.adminGastosApi.dto.TipoPeriodoDTO;
import com.gbb.adminGastosApi.model.TipoPeriodo;

@Mapper(componentModel = "spring")
public interface TipoPeriodoMapper {
	TipoPeriodo toEntity(TipoPeriodoDTO dto);

	TipoPeriodoDTO toDTO(TipoPeriodo entity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void mergeDtoIntoEntity(TipoPeriodoDTO dto, @MappingTarget TipoPeriodo entity);
}