package com.company.chap06.spring;

public class Client2{
	
	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}

	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("connect");
	}
	
	public void send() {
		System.out.println("send to "+host);
	}

	public void close(){
		// TODO Auto-generated method stub
		System.out.println("close");	
	}

}
