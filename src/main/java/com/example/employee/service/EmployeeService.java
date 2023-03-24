package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository repository;
    @Override
    public Employee insert(EmployeeDTO employeeDTO) {
        Employee employee=new Employee(employeeDTO);
        repository.save(employee);
        return employee;
    }
@Override
    public Optional<Employee> getById(int id) {
        Optional<Employee>employee=repository.findById(id);
        if(employee.isPresent()){
            return employee;
        }return null;
    }
    @Override
    public List<Employee> allDetails() {
        List<Employee> messages=repository.findAll();
        return messages;
    }

    @Override
    public Employee update(EmployeeDTO employeeDTO, int id) {
        Employee employee=repository.findById(id).get();
        if(repository.findById(id).isPresent()){
            employee.setName(employeeDTO.getName());
            employee.setProfilePic(employeeDTO.getProfilePic());
            employee.setGender(employeeDTO.getGender());
            employee.setSalary(employeeDTO.getSalary());
            employee.setNotes(employeeDTO.getNotes());
            employee.setStartDate(employeeDTO.getStartDate());
            repository.save(employee);
        }

        return null;
    }

    public String delete(int id) {
        repository.deleteById(id);
        return "data fetched by id is deleted";
    }


}
