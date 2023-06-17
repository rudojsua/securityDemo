package com.example.securityDemo;

import com.example.securityDemo.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import(SecurityConfig.class)
@SpringBootApplication
public class SecurityDemoApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SecurityDemoApplication.class, args);

	}

}
