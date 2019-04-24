package com.tukalo.university.dao;

import com.tukalo.university.model.Department;
import com.tukalo.university.model.Lector;

import java.util.List;
import java.util.Map;

public interface DepartmentDAO {
    Lector findHeadOfDepartment(int id);

    Map<String, Object> findStatisticOfDepartment(int id);

    Integer findAverageSalaryOfDepartment(int id);

    Integer findCountEmployeeOfDepartment(int id);

    List<Department> findAllDepartment();
}
