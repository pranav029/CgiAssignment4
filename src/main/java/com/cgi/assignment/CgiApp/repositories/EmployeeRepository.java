package com.cgi.assignment.CgiApp.repositories;

import com.cgi.assignment.CgiApp.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    Optional<Employee> findByEmpId(String empId);
}
