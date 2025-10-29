package com.sms.classmgnt.controller;

import com.sms.classmgnt.model.Timetable;
import com.sms.classmgnt.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/timetables")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping
    public List<Timetable> getAllTimetables() {
        return timetableService.getAllTimetables();
    }

    @GetMapping("/{id}")
    public Optional<Timetable> getTimetableById(@PathVariable Long id) {
        return timetableService.getTimetableById(id);
    }

    @PostMapping
    public Timetable createTimetable(@RequestBody Timetable timetable) {
        try {
            return timetableService.saveTimetable(timetable);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Timetable updateTimetable(@PathVariable Long id, @RequestBody Timetable timetable) {
        // Ensure the ID is set so that validations can exclude the current record
        timetable.setId(id);
        try {
            return timetableService.saveTimetable(timetable);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTimetable(@PathVariable Long id) {
        timetableService.deleteTimetable(id);
    }
}