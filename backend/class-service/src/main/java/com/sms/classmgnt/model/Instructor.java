package com.sms.classmgnt.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instructorCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Subject> subjects;
}
