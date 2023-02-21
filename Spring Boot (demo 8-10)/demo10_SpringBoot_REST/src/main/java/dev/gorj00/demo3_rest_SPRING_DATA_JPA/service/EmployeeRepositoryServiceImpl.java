package dev.gorj00.demo3_rest_SPRING_DATA_JPA.service;

import dev.gorj00.demo_rest_ORIGINAL.dao.EmployeeRepository;
import dev.gorj00.demo_rest_ORIGINAL.entity.Employee;
import dev.gorj00.demo_rest_ORIGINAL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Used as an alternative with JpaRepository from DAO as opposed to working with DAO and DAOimpl
// Remove @Transactional from methods since JpaRepository handles it as well
@Service
public class EmployeeRepositoryServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRepositoryServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    // No need for @Transactional with JpaRepository
    // @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
