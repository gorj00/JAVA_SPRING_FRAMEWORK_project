package dev.gorj00.demo1_rest_HIBERNATE.demo_rest.dao;

import dev.gorj00.demo_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
