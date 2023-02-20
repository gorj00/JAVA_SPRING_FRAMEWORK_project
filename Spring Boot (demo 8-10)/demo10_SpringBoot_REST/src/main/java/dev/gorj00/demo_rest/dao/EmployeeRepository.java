package dev.gorj00.demo_rest.dao;

import dev.gorj00.demo_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Alternative to writing DAO and DAOImpl code, this handles it and provides crud
}
