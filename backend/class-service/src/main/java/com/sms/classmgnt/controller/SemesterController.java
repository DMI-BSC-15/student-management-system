package com.sms.classmgnt.controller;

import com.sms.classmgnt.model.Semester;
import com.sms.classmgnt.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/semesters")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @GetMapping
    public List<Semester> getAllSemesters() {
        return semesterService.getAllSemesters();
    }

    @GetMapping("/{id}")
    public Optional<Semester> getSemesterById(@PathVariable Long id) {
        return semesterService.getSemesterById(id);
    }

    @PostMapping
    public Semester createSemester(@RequestBody Semester semester) {
        return semesterService.saveSemester(semester);
    }

    @PutMapping("/{id}")
    public Semester updateSemester(@PathVariable Long id, @RequestBody Semester semester) {
        // Let the service handle the update properly
        return semesterService.saveSemester(semester);
    }

    @DeleteMapping("/{id}")
    public void deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
    }
}