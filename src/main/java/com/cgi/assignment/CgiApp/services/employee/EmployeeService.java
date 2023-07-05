package com.cgi.assignment.CgiApp.services.employee;

import com.cgi.assignment.CgiApp.dto.ResponseDto;
import com.cgi.assignment.CgiApp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    ResponseDto<Employee> addEmp(Employee employee);

    ResponseDto<Void> deleteEmp(String empId);

    ResponseDto<List<Employee>> getAllEmp();

    ResponseDto<Employee> updateEmp(String empId, Employee employee);
}
