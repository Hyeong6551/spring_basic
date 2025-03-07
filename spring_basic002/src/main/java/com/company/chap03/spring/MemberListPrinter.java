package com.company.chap03.spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {
//	@Autowired
	private MemberDao memberDao;
	private MemberPrinter printer;

	// MemberDao와 MemberPrinter 둘다 @Autowired로 설정 했을 때
	public MemberListPrinter() {  }
	
	// MemberDao만 @Autowired로 설정했을 때
	public MemberListPrinter(MemberPrinter printer) {
		super();
		this.printer = printer;
	}
	
	// @Autowired 설정 안했을 때
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
}
