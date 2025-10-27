package com.sms.classmgnt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "allocations")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId; // From student management system

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;
}

