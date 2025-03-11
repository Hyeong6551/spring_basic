package com.company.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.company.example.entity.Member;

public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final RowMapper<Member> memberRowMapper = (rs, rowNum) ->{
			Member member = new Member(
				rs.getString("email"),rs.getString("password"),rs.getString("name"),
				rs.getTimestamp("regdate").toLocalDateTime());
			return member;
	};
	
	public Member selectByEmail(String email) {
		String sql = "SELECT * FROM MEMBER WHERE EMAIL=?";
		List<Member> result = jdbcTemplate.query(sql, memberRowMapper,email);
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
		List<Member> result = jdbcTemplate.query(sql, memberRowMapper);
		return result;
	}
}