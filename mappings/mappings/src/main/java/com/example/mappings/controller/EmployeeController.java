package com.example.mappings.controller;

import com.example.mappings.dao.EmployeeDAO;
import com.example.mappings.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeDAO.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return employeeDAO.update(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeDAO.delete(id);
        return "Employee with ID: " + id + " was deleted.";
    }
}
