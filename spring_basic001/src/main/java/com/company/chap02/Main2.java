package com.company.chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	public static void main(String[] args) {
//		HelloWorld helloWorld1 = new HelloWorld();
//		helloWorld1.print();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);
		helloWorld.print();
		System.out.println(helloWorld==helloWorld1);
		
		ctx.close();
	}
}
