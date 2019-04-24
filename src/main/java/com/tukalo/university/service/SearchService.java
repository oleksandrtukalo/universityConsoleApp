package com.tukalo.university.service;

import com.tukalo.university.model.Department;
import com.tukalo.university.model.Lector;

import java.util.List;
import java.util.Map;

public interface SearchService {
    Lector findHeadOfDepartment(int id);

    Map<String, Object> findStatisticOfDepartment(int id);

    int findAverageSalaryOfDepartment(int id);

    int findCountEmployeeOfDepartment(int id);

    List<Lector> findByTemplate(String template);

    List<Department> findAllDepartment();

}
