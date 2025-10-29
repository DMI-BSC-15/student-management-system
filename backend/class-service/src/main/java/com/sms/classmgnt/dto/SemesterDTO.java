package com.sms.classmgnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SemesterDTO {
    private Long id;
    private String semesterName;
    private String startDate;
    private String endDate;
    private boolean isCurrent;
}


