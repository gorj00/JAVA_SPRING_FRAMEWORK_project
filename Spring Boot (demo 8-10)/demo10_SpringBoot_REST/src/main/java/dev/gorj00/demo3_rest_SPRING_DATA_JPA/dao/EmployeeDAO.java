package dev.gorj00.demo3_rest_SPRING_DATA_JPA.dao;

import dev.gorj00.demo_rest_ORIGINAL.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
