package com.sms.classmgnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicSessionDTO {
    private Long id;
    private String sessionName;
    private String startDate;
    private String endDate;
    private boolean isCurrent;
}


