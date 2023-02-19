package com.alok.springbootdemo.service;

import com.alok.springbootdemo.entity.EmployeeEntity;
import com.alok.springbootdemo.model.Employee;
import com.alok.springbootdemo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmailId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        List<Employee> employeeList = employeeEntityList
                .stream()
                .map(employeeEntity -> {
                   Employee employee = new Employee();
                   BeanUtils.copyProperties(employeeEntity, employee);
                   return employee;
                })
                .collect(Collectors.toList());

        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String employeeId) {
        return null;
    }
}
