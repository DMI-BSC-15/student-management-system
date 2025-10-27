package com.sms.classmgnt.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private String courseName;
    private String description;
    private int creditHours;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Subject> subjects;
}

