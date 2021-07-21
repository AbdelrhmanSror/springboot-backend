package com.jumia.SQLite.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootAndSqLiteApplication {

	public static void main(String[] args) {
		SpringApplication application =new SpringApplication(SpringBootAndSqLiteApplication.class);
		Map<String, Object> map = new HashMap<>();
		map.put("server.servlet.context-path", "/customer");
		application.setDefaultProperties(map);
		application.run(args);
	}

}
