package com.sms.classmgnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassEntityDTO {
    private Long id;
    private String classCode;
    private String className;
    private int year;
    private int semester;
    private Long programId;
}


