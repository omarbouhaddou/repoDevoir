package com.example.config_serverD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerDApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerDApplication.class, args);
	}

}
