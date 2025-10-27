package com.sms.classmgnt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "semesters")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String semesterName; // e.g., "Semester 1"
    private String startDate;
    private String endDate;
    private boolean isCurrent;
}
