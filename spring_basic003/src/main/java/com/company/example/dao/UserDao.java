package com.company.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.company.example.entity.User;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = (ResultSet rs, int rowNum) -> {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setAge(rs.getInt("age")); 
        return user;
    };

    public void create(User user) {
        String sql = "INSERT INTO userss (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    public User read(Long id) {
        String sql = "SELECT * FROM userss WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }

    public List<User> readAll() {
        String sql = "SELECT * FROM userss";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    public void update(User user) {
        String sql = "UPDATE userss SET name = ?, email = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM userss WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
} 