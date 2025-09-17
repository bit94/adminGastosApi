package com.gbb.adminGastosApi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gbb.adminGastosApi.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}