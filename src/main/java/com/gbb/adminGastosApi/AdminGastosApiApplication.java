package com.gbb.adminGastosApi;

import java.util.Collections;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AdminGastosApiApplication {

	public static void main(String[] args) {
        // Railway está asignando 8080, pero necesita un puerto diferente
        String port = System.getenv("PORT");
        
        if ("8080".equals(port)) {
            // Si Railway asigna 8080, usa un puerto aleatorio
            port = "0"; // Puerto aleatorio
            System.out.println("⚠️  Puerto 8080 detectado, usando puerto aleatorio");
        } else {
            // Usa el puerto asignado o default
            port = System.getenv().getOrDefault("PORT", "8080");
        }
        
        System.out.println("🚀 Iniciando aplicación en puerto: " + port);
        
        new SpringApplicationBuilder(AdminGastosApiApplication.class)
            .properties(Collections.singletonMap("server.port", port))
            .run(args);
	}

}
