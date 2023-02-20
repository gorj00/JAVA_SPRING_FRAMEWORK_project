package dev.gorj00.demo_rest.dao;

import dev.gorj00.demo_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
