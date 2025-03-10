package com.company.chap08.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {
		String sql = "SELECT * FROM MEMBER WHERE EMAIL=?";
		List<Member> result = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
					Member member = new Member(
					rs.getString("email"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getTimestamp("regdate").toLocalDateTime());
				member.setId(rs.getLong("id"));	// 안쓰면 null값 반환
				return member;
		},email);
		return result.get(0);
	}

	public void insert(Member member) {
		String sql = "insert into MEMBER(email, password, name, regdate) values (?,?,?, now())";
		jdbcTemplate.update(sql, member.getEmail(), member.getPassword(), member.getName());
	}

	public void update(Member member) {
		String sql = "update MEMBER set email=?, password=?, name=? where id=?";
		jdbcTemplate.update(sql, member.getEmail() ,member.getPassword(), member.getName(),member.getId());
	}

	public List<Member> selectAll() {
		String sql = "SELECT * FROM MEMBER";
//		List<Member> result = jdbcTemplate.query(sql, new RowMapper<Member>() {
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Member member = new Member(
//						rs.getString("email"),
//						rs.getString("password"),
//						rs.getString("name"),
//						rs.getTimestamp("regdate").toLocalDateTime());
//				member.setId(rs.getLong("id"));
//				return member;
//			}
//		});
		
		// Lambda 이용
		List<Member> result = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Member member = new Member(
					rs.getString("email"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getTimestamp("regdate").toLocalDateTime());
			member.setId(rs.getLong("id"));
			return member;
	});
		return result;
	}
}