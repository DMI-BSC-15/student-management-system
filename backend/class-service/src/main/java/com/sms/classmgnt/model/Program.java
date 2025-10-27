package com.sms.classmgnt.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String programCode;
    private String programName;
    private String description;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Course> courses;
}

