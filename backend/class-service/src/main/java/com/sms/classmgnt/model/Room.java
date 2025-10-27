package com.sms.classmgnt.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomCode;
    private String roomName;
    private int capacity;
    private String type; // Lecture Hall, Lab, Seminar Room

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Timetable> timetables;
}

