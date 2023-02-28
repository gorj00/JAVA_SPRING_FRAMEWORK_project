package dev.gorj00.demo3_rest_SPRING_DATA_JPA.dao;

import dev.gorj00.demo_rest_ORIGINAL.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") // for custom plural name or custom name
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Alternative to writing DAO and DAOImpl code, this handles it and provides crud
}
