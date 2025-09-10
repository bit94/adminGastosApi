package com.gbb.adminGastosApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminGastosApiApplication {

	public static void main(String[] args) {
		String port = System.getenv().getOrDefault("PORT", "8080");

		// VERIFICACIÓN EXPLÍCITA
		System.out.println("🔍 Variable PORT: " + System.getenv("PORT"));
		System.out.println("🔍 Usando puerto: " + port);

		// FORZAR configuración
		System.setProperty("server.port", port);

		SpringApplication.run(AdminGastosApiApplication.class, args);
	}

}
