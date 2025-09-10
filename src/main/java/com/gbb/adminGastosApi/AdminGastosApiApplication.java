package com.gbb.adminGastosApi;

import java.util.Collections;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AdminGastosApiApplication {

	public static void main(String[] args) {
		// Obtener el puerto de Railway o usar puerto por defecto
        String port = System.getenv().getOrDefault("PORT", "8080");
        
        System.out.println("🚀 Iniciando aplicación en puerto: " + port);
        
        // Configurar Spring Boot para usar el puerto específico
        new SpringApplicationBuilder(AdminGastosApiApplication.class)
            .properties(Collections.singletonMap("server.port", port))
            .run(args);
	}

}
