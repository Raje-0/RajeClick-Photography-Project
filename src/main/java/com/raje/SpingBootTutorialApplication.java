package com.raje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.raje.springJPARepository")
@EntityScan("com.raje.entity")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class SpingBootTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootTutorialApplication.class, args);
	}

}
