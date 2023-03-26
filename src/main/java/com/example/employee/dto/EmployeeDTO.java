package com.example.employee.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{1,}\\s{1,}[A-Z]{1}[a-z]{1,}$",message="First name and Last name starts with caps and give space in between " )
    private String name;
    @NotEmpty(message = "profile pic can not empty")
    private String profilePic;
    @NotNull(message = "gender can not be null")
    private String gender;
    @NotNull(message = "salary cannot be blank")
    private long salary;
    @Pattern(regexp = "^[A-Z]{1,}",message = "Notes cannot contain numbers")
    private String notes;
    @NotBlank(message = "startdate should be past date")
    private String startDate;
    private List<String> department;
}
