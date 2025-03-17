package com.example.mappings.dao;

import com.example.mappings.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Optional<Employee> findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return Optional.ofNullable(employee);
    }

    @Override
    @Transactional
    public Employee update(int id, Employee updatedEmployee) {
        Employee existingEmployee = entityManager.find(Employee.class, id);
        if (existingEmployee == null) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setSkills(updatedEmployee.getSkills());

        entityManager.merge(existingEmployee);
        return existingEmployee;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
        entityManager.remove(employee);
    }
}
