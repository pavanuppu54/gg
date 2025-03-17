package com.example.mappings;

import com.example.mappings.dao.EmployeeDAO;
import com.example.mappings.entity.Employee;
import com.example.mappings.entity.Skills;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingsApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO) {
//		return runner -> {
//			createEmployee(employeeDAO);
//		};
//	}
//
//	private void createEmployee(EmployeeDAO employeeDAO) {
//		// Creating Employee
//		Employee tempEmployee = new Employee("Pavan", "pavan@gmail.com");
//
//		// Creating Skills
//		Skills tempSkills = new Skills("Java, Spring Boot");
//
//		// Setting Skills in Employee
//		tempEmployee.setSkills(tempSkills);
//
//		// Saving Employee (also saves Skills due to CascadeType.ALL)
//		employeeDAO.save(tempEmployee);
//
//		System.out.println("Employee Saved: " + tempEmployee);
//	}
}
