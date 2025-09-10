package com.gbb.adminGastosApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminGastosApiApplication {

	public static void main(String[] args) {
		String port = System.getenv("PORT");
        System.out.println("PORT environment variable: " + port);
		SpringApplication.run(AdminGastosApiApplication.class, args);
	}

}
