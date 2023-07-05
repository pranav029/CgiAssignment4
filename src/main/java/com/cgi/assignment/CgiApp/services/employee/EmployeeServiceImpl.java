package com.cgi.assignment.CgiApp.services.employee;

import com.cgi.assignment.CgiApp.dto.ResponseDto;
import com.cgi.assignment.CgiApp.entities.Employee;
import com.cgi.assignment.CgiApp.exceptions.ResourceNotFoundException;
import com.cgi.assignment.CgiApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseDto<Employee> addEmp(Employee employee) {
        Employee newEmp = employeeRepository.save(employee);
        return new ResponseDto<>("Employee created successfully", true, newEmp, null);
    }

    @Override
    public ResponseDto<Void> deleteEmp(String empId) {
        Employee employee = employeeRepository.findByEmpId(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", empId));
        employeeRepository.delete(employee);
        return new ResponseDto<>("Employee deleted successfully", true, null, null);
    }

    @Override
    public ResponseDto<List<Employee>> getAllEmp() {
        Iterable<Employee> itrEmp = employeeRepository.findAll();
        List<Employee> emps = StreamSupport.stream(itrEmp.spliterator(), false).toList();
        return new ResponseDto<>(null, true, emps, null);
    }

    @Override
    public ResponseDto<Employee> updateEmp(String empId, Employee employee) {
        Employee emp = employeeRepository.findByEmpId(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", empId));
        emp.setEmpName(employee.getEmpName());
        emp.setEmpDesignation(employee.getEmpDesignation());
        Employee updateEmp = employeeRepository.save(emp);
        return new ResponseDto<>("Employee updated successfully", true, updateEmp, null);
    }
}
