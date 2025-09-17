package com.gbb.adminGastosApi.config;

import com.gbb.adminGastosApi.model.Rol;
import com.gbb.adminGastosApi.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupConfig {

	@Bean
	public CommandLineRunner preloadRoles(RolRepository rolRepository) {
		return args -> {
			if (rolRepository.findByNombre("ADMIN").isEmpty()) {
				rolRepository.save(new Rol(null, "ADMIN"));
			}
			if (rolRepository.findByNombre("USER").isEmpty()) {
				rolRepository.save(new Rol(null, "USER"));
			}
		};
	}
}