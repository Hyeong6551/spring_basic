package com.company.interTest;

public class Main {

	public static void main(String[] args) {
//		InterF i1 = new InterF() {
//
//			@Override
//			public String method(int i, String s) {
//				return i+", "+s;
//			}
//		};
//		System.out.println(i1.method(100,"ㅇㅇ"));	
		
		InterF ii = (i,s) -> i+", "+s;
		System.out.println(ii.method(100, "dd"));
		// 람다식를 이용한 인터페이싀 구현 - 인터페이스에서 메서드가 1개일 때만 가능
//		InterF i1 = (1,"dd") -> System.out.println("dd");
//		i1.method();
	}
}
