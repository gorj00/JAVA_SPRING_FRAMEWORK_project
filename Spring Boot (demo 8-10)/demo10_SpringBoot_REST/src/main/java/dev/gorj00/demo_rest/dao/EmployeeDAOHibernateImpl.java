package dev.gorj00.demo_rest.dao;

import dev.gorj00.demo_rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired // optional
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional // handles transaction manager (start, commit, etc.)
    public List<Employee> findAll() {
        // get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class); // native Hibernate API

        // execute the query and get result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }
}
