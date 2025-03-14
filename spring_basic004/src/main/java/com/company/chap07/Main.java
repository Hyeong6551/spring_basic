package com.company.chap07;

public class Main {
	public static void main(String[] args) {
		int num=5;
		ExecuteTime et1 = new ExecuteTime(new ImpeCalculator());
		System.out.println(et1.factorial(num));
		
		ExecuteTime et2 = new ExecuteTime(new RecCalculator());
		System.out.println(et2.factorial(num));
	}
}
