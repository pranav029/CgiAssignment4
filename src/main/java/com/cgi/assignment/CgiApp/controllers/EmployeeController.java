package com.cgi.assignment.CgiApp.controllers;

import com.cgi.assignment.CgiApp.dto.ResponseDto;
import com.cgi.assignment.CgiApp.entities.Employee;
import com.cgi.assignment.CgiApp.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto<Employee>> createEmp(@RequestBody Employee employee) {
        ResponseDto<Employee> responseDto = employeeService.addEmp(employee);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto<Void>> deleteEmp(@PathVariable String empId) {
        ResponseDto<Void> responseDto = employeeService.deleteEmp(empId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<Employee>>> getAllEmp() {
        ResponseDto<List<Employee>> responseDto = employeeService.getAllEmp();
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto<Employee>> updateEmp(@PathVariable String empId, @RequestBody Employee employee) {
        ResponseDto<Employee> responseDto = employeeService.updateEmp(empId, employee);
        return ResponseEntity.ok(responseDto);
    }
}
