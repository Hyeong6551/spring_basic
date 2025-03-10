package com.company.interTest;

public class Impl_InterF implements InterF{

	@Override
	public String method(int i, String s) {
		return i+", "+s;
	}

//	@Override
//	public void method2() {
//		System.out.println("method 2");
//		
//	}

}
