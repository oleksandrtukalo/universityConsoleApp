package com.tukalo.university.rowMapper;

import com.tukalo.university.model.Department;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Department> {
    @Nullable
    @Override
    public Department mapRow(ResultSet rs, int i) throws SQLException {
        Department department = new Department();
        department.setDepId(rs.getInt("dep_id"));
        department.setDepName(rs.getString("dep_name"));
        department.setDepHead(rs.getInt("dep_head_lec_id"));
        return department;
    }
}
