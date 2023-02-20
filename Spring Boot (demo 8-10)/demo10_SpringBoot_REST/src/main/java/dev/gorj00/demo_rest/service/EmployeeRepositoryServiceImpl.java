package dev.gorj00.demo_rest.service;

import dev.gorj00.demo_rest.dao.EmployeeDAO;
import dev.gorj00.demo_rest.dao.EmployeeRepository;
import dev.gorj00.demo_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
