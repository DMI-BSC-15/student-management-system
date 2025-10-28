package com.sms.classmgnt.controller;

import com.sms.classmgnt.model.AcademicSession;
import com.sms.classmgnt.service.AcademicSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/academic-sessions")
public class AcademicSessionController {

    @Autowired
    private AcademicSessionService academicSessionService;

    @GetMapping
    public List<AcademicSession> getAllAcademicSessions() {
        return academicSessionService.getAllAcademicSessions();
    }

    @GetMapping("/{id}")
    public Optional<AcademicSession> getAcademicSessionById(@PathVariable Long id) {
        return academicSessionService.getAcademicSessionById(id);
    }

    @PostMapping
    public AcademicSession createAcademicSession(@RequestBody AcademicSession academicSession) {
        return academicSessionService.saveAcademicSession(academicSession);
    }

    @PutMapping("/{id}")
    public AcademicSession updateAcademicSession(@PathVariable Long id, @RequestBody AcademicSession academicSession) {
        // Let the service handle the update properly
        return academicSessionService.saveAcademicSession(academicSession);
    }

    @DeleteMapping("/{id}")
    public void deleteAcademicSession(@PathVariable Long id) {
        academicSessionService.deleteAcademicSession(id);
    }
}