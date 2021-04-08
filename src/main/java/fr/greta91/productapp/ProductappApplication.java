package fr.greta91.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProductappApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

}
