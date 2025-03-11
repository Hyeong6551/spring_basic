package com.company.example;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.example.config.DatabaseConfig;
import com.company.example.dao.MemberDao;
import com.company.example.entity.Member;


public class MainForSpring {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(DatabaseConfig.class);
		MemberDao memberDao = ctx.getBean(MemberDao.class);
		
		// insert
//		Member insertMember = new Member("kim@naver.com", "1324", "동길동", LocalDateTime.now());
//		memberDao.insert(insertMember);
		
		// update
//		Member updateMember = new Member(1L,"jae@naver.com","1111","형임니다");
//		memberDao.update(updateMember);
		
		for(Member member : memberDao.selectAll()) {
			System.out.println(member);
		}
		
		Member members = new Member("kim@naver.com");
		System.out.println(memberDao.selectByEmail(members.getEmail()));
	}
}