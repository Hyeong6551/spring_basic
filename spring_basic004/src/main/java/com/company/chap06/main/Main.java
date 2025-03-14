package com.company.chap06.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.company.chap06.config.AppCtx;
import com.company.chap06.spring.Client;
import com.company.chap06.spring.Client2;

public class Main {
	public static void main(String[] args) {
		// 컨테이너 초기화x
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		// 빈 객체를 구해 사용
//		Client client = ctx.getBean(Client.class);
//		client.send();
		
		Client2 client2 = ctx.getBean(Client2.class);
		client2.send();
		
		// 컨테이너 종료
		ctx.close();
	}
}
