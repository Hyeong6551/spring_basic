package com.company.chap07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.company.chap06.spring.Client;
import com.company.chap06.spring.Client2;
import com.company.chap07.Calculator;
import com.company.chap07.ImpeCalculator;
import com.company.chap07.RecCalculator;
import com.company.chap07.aspect.ExecuteTimeAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
	
	@Bean
	public ExecuteTimeAspect executeTimeAspect() {
		return new ExecuteTimeAspect();
	}
	
	@Bean
	public Calculator calculator() {
		return new RecCalculator();
//		return new ImpeCalculator();
	}
}
