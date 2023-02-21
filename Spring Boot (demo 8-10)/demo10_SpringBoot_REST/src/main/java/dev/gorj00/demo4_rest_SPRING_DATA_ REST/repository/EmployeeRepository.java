package dev.gorj00.demo4_rest_SPRING_DATA_;

import dev.gorj00.demo_rest_ORIGINAL.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Alternative to writing DAO and DAOImpl code, this handles it and provides crud
}
