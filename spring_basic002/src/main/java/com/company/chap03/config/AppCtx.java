package com.company.chap03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.chap03.spring.ChangePasswordService;
import com.company.chap03.spring.MemberDao;
import com.company.chap03.spring.MemberListPrinter;
import com.company.chap03.spring.MemberPrinter;
import com.company.chap03.spring.MemberRegisterService;

@Configuration
public class AppCtx {

	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean 
	public MemberRegisterService regSvc() {
		return new MemberRegisterService();	// 1. 생성자를 사용한 의존 주입 방식
	}
	
	@Bean
	public ChangePasswordService pwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao());	// 2. 세터를 사용한 의존 주입 방식
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberPrinter());
	}
}
