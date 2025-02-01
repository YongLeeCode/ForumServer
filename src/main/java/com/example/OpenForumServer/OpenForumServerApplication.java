package com.example.OpenForumServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing()
@SpringBootApplication
public class OpenForumServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenForumServerApplication.class, args);
	}

}
