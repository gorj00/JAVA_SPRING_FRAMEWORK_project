package dev.gorj00.demo3_rest_SPRING_DATS_JPA.demo_rest.dao;

import dev.gorj00.demo_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
