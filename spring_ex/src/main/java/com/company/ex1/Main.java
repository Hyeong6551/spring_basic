package com.company.ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("첫 번째 숫자 입력 : ");
		int n1 = Integer.parseInt(br.readLine());
		System.out.println("두 번째 숫자 입력 : ");
		int n2 = Integer.parseInt(br.readLine());
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		PrintNumber p1 = ctx.getBean(PrintNumber.class);
		p1.print(n1,n2);
		ctx.close();
	}
}
