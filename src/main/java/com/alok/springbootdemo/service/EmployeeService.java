package com.alok.springbootdemo.service;

import com.alok.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee save(Employee employee);
    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(String employeeId);
    public String deleteEmployeeById(String employeeId);
}
