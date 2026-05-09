package com.example.EntityCraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EntityCraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityCraftApplication.class, args);
	}

}
