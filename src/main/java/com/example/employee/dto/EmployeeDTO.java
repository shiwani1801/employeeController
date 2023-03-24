package com.example.employee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private String profilePic;
    private String gender;
    private long salary;
    private String notes;
    private String startDate;
}
