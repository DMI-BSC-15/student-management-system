package com.sms.classmgnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllocationDTO {
    private Long id;
    private Long studentId;
    private Long classId;
}


