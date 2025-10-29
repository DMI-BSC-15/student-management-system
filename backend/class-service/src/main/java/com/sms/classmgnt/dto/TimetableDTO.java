package com.sms.classmgnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimetableDTO {
    private Long id;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private Long subjectId;
    private Long classId;
    private Long roomId;
}


