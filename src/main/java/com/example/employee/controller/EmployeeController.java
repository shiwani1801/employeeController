package com.example.employee.controller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping ("/insert")
    public Employee insert(@RequestBody EmployeeDTO employeeDTO){
        Employee employee=service.insert(employeeDTO);
        return employee;
    }
    @GetMapping("/getById/{id}")
    public Optional<Employee>getById(@PathVariable int id){
        Optional<Employee> employee = service.getById(id);
        return employee;
    }
    @GetMapping("getAll")
    public List<Employee> allDetails(){
        List<Employee>employees=service.allDetails();
        return employees;
    }
    @PutMapping("/update/{id}")
    public  Employee update(@RequestBody EmployeeDTO employeeDTO,@PathVariable int id){
        Employee employee=service.update(employeeDTO ,id);
        return employee;
    }
    @DeleteMapping("/delete/{id}")
    public  String delete(@PathVariable int id){
        String response=service.delete(id);
        return response;
    }
}
