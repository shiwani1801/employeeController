package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Employee insert(EmployeeDTO employeeDTO);
    Optional<Employee>getById(int id);
    List<Employee> allDetails();
    Employee update(EmployeeDTO employeeDTO,int id);

    String delete(int id);
}
