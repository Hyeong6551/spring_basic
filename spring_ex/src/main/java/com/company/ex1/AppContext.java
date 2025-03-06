package com.company.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public PrintNumber printNumber() {
		return new PrintNumber();
	}
}
