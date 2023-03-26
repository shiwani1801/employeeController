package com.example.employee.model;

import com.example.employee.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String profilePic;
    private String gender;
    private long salary;
    private String notes;
    private String startDate;
    @ElementCollection
    @CollectionTable(name = "department_table",joinColumns = @JoinColumn(name = "id"))
    @Column
    private List<String> department;
    public Employee(EmployeeDTO employeeDTO){
        this.name=employeeDTO.getName();
        this.profilePic=employeeDTO.getProfilePic();
        this.gender=employeeDTO.getGender();
        this.salary=employeeDTO.getSalary();
        this.notes=employeeDTO.getNotes();
        this.startDate=employeeDTO.getStartDate();
        this.department=employeeDTO.getDepartment();
    }
}
