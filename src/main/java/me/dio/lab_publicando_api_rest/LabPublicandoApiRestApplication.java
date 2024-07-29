package me.dio.lab_publicando_api_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LabPublicandoApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPublicandoApiRestApplication.class, args);
	}

}
