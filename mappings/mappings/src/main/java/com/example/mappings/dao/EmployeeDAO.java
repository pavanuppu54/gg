package com.example.mappings.dao;

import com.example.mappings.entity.Employee;

import java.util.Optional;

public interface EmployeeDAO {
    Employee save(Employee employee);
    Optional<Employee> findById(int id);
    Employee update(int id, Employee updatedEmployee);
    void delete(int id);
}
