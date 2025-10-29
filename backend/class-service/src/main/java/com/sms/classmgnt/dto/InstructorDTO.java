package com.sms.classmgnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDTO {
    private Long id;
    private String instructorCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;
}


