package com.tukalo.university.dao;

import com.tukalo.university.RowMapper.DepartmentRowMapper;
import com.tukalo.university.RowMapper.LectorRowMapper;
import com.tukalo.university.model.Department;
import com.tukalo.university.model.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDaoImpl implements DepartmentDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Lector findHeadOfDepartment(int id) {
        String query = "SELECT * FROM lectors" +
                " WHERE lec_id = (SELECT dep_head_lec_id FROM university.departments WHERE dep_id=?)";
        return jdbcTemplate.queryForObject(query, new LectorRowMapper(), id);
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public Map<String, Object> findStatisticOfDepartment(int id) throws NullPointerException {
        String queryProf = "SELECT COUNT(CASE WHEN `degree` LIKE 'professor' THEN 1 END) AS ProfessorCount," +
                " COUNT(CASE WHEN `degree` LIKE 'assistant' THEN 1 END) AS AssistantCount," +
                " COUNT(CASE WHEN `degree` LIKE 'associate professor' THEN 1 END) AS AssocProfesCount" +
                " FROM lectors LEFT JOIN lector_department ON lector_department.lec_id = lectors.lec_id WHERE lector_department.dep_id=?";
        return jdbcTemplate.queryForMap(queryProf, id);
    }

    @Override
    public Integer findAverageSalaryOfDepartment(int id) {
        String query = "SELECT AVG(salary) FROM lectors left join lector_department" +
                " on lector_department.lec_id = lectors.lec_id where lector_department.dep_id =?";
        return jdbcTemplate.queryForObject(query, Integer.class, id);
    }

    @Override
    public Integer findCountEmployeeOfDepartment(int id) {
        String query = "SELECT COUNT(lec_id) FROM lector_department WHERE dep_id=?";
        return jdbcTemplate.queryForObject(query, Integer.class, id);
    }

    @Override
    public List<Department> findAllDepartment() {
        String query = "SELECT * FROM departments";
        RowMapper<Department> rowMapper = new DepartmentRowMapper();
        return jdbcTemplate.query(query, rowMapper);
    }
}
