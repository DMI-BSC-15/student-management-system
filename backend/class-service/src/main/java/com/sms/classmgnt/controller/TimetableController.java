package com.sms.classmgnt.controller;

import com.sms.classmgnt.model.Timetable;
import com.sms.classmgnt.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return timetableService.saveTimetable(timetable);
    }

    @PutMapping("/{id}")
    public Timetable updateTimetable(@PathVariable Long id, @RequestBody Timetable timetable) {
        // Let the service handle the update properly
        return timetableService.saveTimetable(timetable);
    }

    @DeleteMapping("/{id}")
    public void deleteTimetable(@PathVariable Long id) {
        timetableService.deleteTimetable(id);
    }
}