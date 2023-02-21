package dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.dao;

import dev.gorj00.demo_rest.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.entity.Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        List<dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.entity.Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.entity.Employee findById(int id) {
        dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.entity.Employee employee = entityManager.find(dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.entity.Employee.class, id);
        return employee;
    }

    @Override
    public void save(dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.entity.Employee employee) {
        dev.gorj00.demo2_rest_STANDARD_JPA.demo_rest.entity.Employee dbEmployee = entityManager.merge(employee);
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
