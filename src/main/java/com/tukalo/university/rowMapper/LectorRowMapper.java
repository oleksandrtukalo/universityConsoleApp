package com.tukalo.university.rowMapper;

import com.tukalo.university.model.Lector;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LectorRowMapper implements RowMapper<Lector> {
    @Nullable
    @Override
    public Lector mapRow(ResultSet rs, int i) throws SQLException {
        Lector lector = new Lector();
        lector.setfName(rs.getString("fname"));
        lector.setlName(rs.getString("lname"));
        lector.setDegree(rs.getString("degree"));
        lector.setSalary(rs.getInt("salary"));
        // lector.setDepartment(rs.ge);
        return lector;
    }
}
