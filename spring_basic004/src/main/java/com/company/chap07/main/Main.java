package com.company.chap07.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.chap07.Calculator;
import com.company.chap07.config.AppCtx;


public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		long num = 5;
		
		Calculator cal = ctx.getBean("calculator",Calculator.class);
		long factNum = cal.factorial(num);
		System.out.println(factNum);
		System.out.println(cal.getClass().getSimpleName());
		
		// 컨테이너 종료
		ctx.close();
	}
}
