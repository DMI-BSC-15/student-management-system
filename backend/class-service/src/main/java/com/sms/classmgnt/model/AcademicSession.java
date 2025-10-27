package com.sms.classmgnt.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "academic_sessions")
public class AcademicSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionName; // e.g., "2024/2025"
    private String startDate;
    private String endDate;
    private boolean isCurrent;
}
