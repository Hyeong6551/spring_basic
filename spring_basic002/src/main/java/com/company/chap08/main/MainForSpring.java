package com.company.chap08.main;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.chap03.config.AppCtx;
import com.company.chap08.spring.Member;
import com.company.chap08.spring.MemberDao;

public class MainForSpring {
	
	private static ApplicationContext ctx = null;	

	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean(MemberDao.class);
		Member member = new Member("kim@korea.com", "1234", "홍길동", LocalDateTime.now());
		memberDao.insert(member);
		System.out.println("입력 성공!");
	}
}