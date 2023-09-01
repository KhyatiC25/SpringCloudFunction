package com.emp.d;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DApplication {

	public static void main(String[] args) {
		SpringApplication.run(DApplication.class, args);
	}

	@Bean
	public Function<String, String> reverse() {
		return (input) -> new StringBuilder(input).reverse().toString();
	}

	@Bean
	public Consumer<String> printMessage() {
		return (input) -> System.out.println(input);
	}

}
