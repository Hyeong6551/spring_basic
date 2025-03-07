package com.company.chap08.spring;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {
		return null;
	}

	public void insert(Member member) {
		String sql = "insert into MEMBER(email, password, name, regdate) values (?,?,?, now())";
		jdbcTemplate.update(sql, member.getEmail(), member.getPassword(), member.getName());
	}

	public void update(Member member) {

	}
}
