package dev.gorj00.demo1_rest_HIBERNATE.dao;

import dev.gorj00.demo_rest_ORIGINAL.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
