package com.example.employee.controller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.ResponseDTO;
import com.example.employee.model.Employee;
import com.example.employee.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    IEmployeeService service;

    @PostMapping ("/insert")
    public ResponseEntity<ResponseDTO> insert(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee employee=service.insert(employeeDTO);
        ResponseDTO responseDTO=new ResponseDTO("Data inserted successfully",employee);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO>getById(@PathVariable int id){
        Optional<Employee> employee = service.getById(id);
        ResponseDTO responseDTO=new ResponseDTO("Id is found",employee);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }
    @GetMapping("getAll")
    public ResponseEntity<ResponseDTO>allDetails(){
        List<Employee>employees=service.allDetails();
        ResponseDTO responseDTO=new ResponseDTO("data found" ,employees);

        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);    }
    @PutMapping("/update/{id}")
    public  ResponseEntity<ResponseDTO> update( @Valid @RequestBody EmployeeDTO employeeDTO,@PathVariable int id){
        Employee employee=service.update(employeeDTO ,id);
        ResponseDTO responseDTO=new ResponseDTO("data updated seccussfully",employee);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<ResponseDTO> delete(@PathVariable int id){
        String response=service.delete(id);
        ResponseDTO responseDTO=new ResponseDTO("Id is found",response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);    }
    @GetMapping("/getByDepartment/{department}")
    public  ResponseEntity<ResponseDTO>getByDepartment(@PathVariable String department){
        List<Employee>employees=service.getByDepartment(department);
        ResponseDTO responseDTO=new ResponseDTO("dept are found",employees);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);    }
}
