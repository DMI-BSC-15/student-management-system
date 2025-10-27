package com.sms.classmgnt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "timetables")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayOfWeek;  // e.g., Monday
    private String startTime;  // e.g., 08:00
    private String endTime;    // e.g., 10:00

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
