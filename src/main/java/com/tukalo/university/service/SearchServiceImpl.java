package com.tukalo.university.service;

import com.tukalo.university.dao.DepartmentDAO;
import com.tukalo.university.dao.LectorDAO;
import com.tukalo.university.model.Department;
import com.tukalo.university.model.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    private final DepartmentDAO departmentDAO;
    private final LectorDAO lectorDAO;

    @Autowired
    public SearchServiceImpl(DepartmentDAO departmentDAO, LectorDAO lectorDAO) {
        this.departmentDAO = departmentDAO;
        this.lectorDAO = lectorDAO;
    }

    @Override
    public Lector findHeadOfDepartment(int id) {
        return this.departmentDAO.findHeadOfDepartment(id);
    }

    @Override
    public Map<String, Object> findStatisticOfDepartment(int id) {
        return this.departmentDAO.findStatisticOfDepartment(id);
    }

    @Override
    public int findAverageSalaryOfDepartment(int id) {
        return this.departmentDAO.findAverageSalaryOfDepartment(id);
    }

    @Override
    public int findCountEmployeeOfDepartment(int id) {
        return this.departmentDAO.findCountEmployeeOfDepartment(id);
    }

    @Override
    public List<Lector> findByTemplate(String template) {
        return this.lectorDAO.findByTemplate(template);
    }

    @Override
    public List<Department> findAllDepartment() {
        return this.departmentDAO.findAllDepartment();
    }


}
