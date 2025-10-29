package com.sms.classmgnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    private Long id;
    private String subjectCode;
    private String subjectName;
    private int creditHours;
    private String type;
    private Long courseId;
    private Long instructorId;
}


