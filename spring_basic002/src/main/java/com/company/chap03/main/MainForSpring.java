package com.company.chap03.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.chap03.assembler.Assembler;
import com.company.chap03.config.AppCtx;
import com.company.chap03.spring.ChangePasswordService;
import com.company.chap03.spring.DuplicateMemberException;
import com.company.chap03.spring.MemberListPrinter;
import com.company.chap03.spring.MemberNotFoundException;
import com.company.chap03.spring.MemberRegisterService;
import com.company.chap03.spring.RegisterRequest;
import com.company.chap03.spring.WrongIdPasswordException;

public class MainForSpring {
	
	private static ApplicationContext ctx = null;	

	public static void main(String[] args) throws IOException {
		// 1. 스프링 컨테이너 생성, AppCtx로 부터 생성할 객체와 의존주입 대상 설정
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if (command.equalsIgnoreCase("list")) {
				processListCommand();
				continue;
			}
			printHelp();
		}
	}

//	private static Assembler assembler = new Assembler();

	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}
		// 2.ctx.getBean("메서드명",클래스명) 으로 변경
		// 메서드명은 생략 가능하지만 클래스명은 생략 불가능
		MemberRegisterService regSvc = ctx.getBean("regSvc",MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.\n");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}

	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) {
			printHelp();
			return;
		}
		// 2.ctx.getBean("메서드명",클래스명) 으로 변경
		// 메서드명은 생략 가능하지만 클래스명은 생략 불가능
		ChangePasswordService changePwdSvc = 
				ctx.getBean("pwdSvc",ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		} catch (WrongIdPasswordException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter",MemberListPrinter.class);
		listPrinter.printAll();
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}
}