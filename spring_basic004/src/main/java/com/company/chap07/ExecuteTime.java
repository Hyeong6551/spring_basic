package com.company.chap07;

public class ExecuteTime implements Calculator{
	
	private Calculator delegate;
	
	public ExecuteTime(Calculator delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		System.out.printf("%s.factorial : %d, time : %d\n",delegate.getClass().getSimpleName(),num,(end-start));
		return result;
	}

}
