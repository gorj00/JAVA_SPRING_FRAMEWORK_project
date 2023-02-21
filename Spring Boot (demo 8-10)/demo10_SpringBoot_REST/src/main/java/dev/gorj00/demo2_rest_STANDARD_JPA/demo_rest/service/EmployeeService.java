package dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.service;

import dev.gorj00.demo_rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
