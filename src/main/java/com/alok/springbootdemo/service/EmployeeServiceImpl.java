package com.alok.springbootdemo.service;

import com.alok.springbootdemo.controller.EmployeeController;
import com.alok.springbootdemo.exception.EmployeeNotFoundException;
import com.alok.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employees = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmailId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
//        Employee employee = null;
//        for(Employee emp : employees) {
//            if(emp.getEmployeeId().equals(employeeId))
//                employee = emp;
//        }
//
//        return employee;

        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id " + employeeId));
    }
}
