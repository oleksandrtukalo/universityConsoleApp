package com.tukalo.university.dao;

import com.tukalo.university.RowMapper.LectorRowMapper;
import com.tukalo.university.model.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectorDAOImpl implements LectorDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LectorDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Lector> findByTemplate(String template) {
        String query = "SELECT * FROM lectors WHERE lname LIKE " + template + " or fname LIKE " + template;
        RowMapper<Lector> rowMapper = new LectorRowMapper();
        return jdbcTemplate.query(query, rowMapper);
    }
}
