package com.productmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ProjectManagerTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerTaskApplication.class, args);
	}

}
