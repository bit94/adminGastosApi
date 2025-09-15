package com.gbb.adminGastosApi.repository.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CatalogoRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
