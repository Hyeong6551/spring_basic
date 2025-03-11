package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DbConfig;
import config.DbQueryConfig;
import dbquery.DbQuery;
import spring.MemberDao;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class,
				DbQueryConfig.class);

		MemberDao md = ctx.getBean(MemberDao.class);
		System.out.println(md.count());
		System.out.println(md.selectByEmail("jae@naver.com"));
		ctx.close();
	}
}
