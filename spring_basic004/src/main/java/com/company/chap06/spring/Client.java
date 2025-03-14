package com.company.chap06.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean{
	
	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}

	// Bean이 끝나기 전
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destory");
	}
	
	public void send() {
		System.out.println("send to "+host);
	}

	// Bean이 실행되기 전
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet");	
	}

}
