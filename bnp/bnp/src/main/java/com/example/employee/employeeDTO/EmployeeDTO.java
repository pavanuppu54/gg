package com.example.employee.employeeDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.example.employee.entity.Employee;

public record EmployeeDTO(
        Long id,

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Department is required")
        @Size(min = 2, max = 30, message = "Department must be between 2 and 30 characters")
        String department
) {
    // Constructor to convert Entity to DTO
    public EmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getEmail(), employee.getDepartment());
    }
}
