package com.sms.classmgnt.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classCode; // e.g., CS2A
    private String className;
    private int year;
    private int semester;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL)
    private List<Allocation> allocations;

    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL)
    private List<Timetable> timetables;
}
