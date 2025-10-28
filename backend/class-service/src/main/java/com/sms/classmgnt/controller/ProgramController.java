package com.sms.classmgnt.controller;

import com.sms.classmgnt.model.Program;
import com.sms.classmgnt.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @GetMapping
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{id}")
    public Optional<Program> getProgramById(@PathVariable Long id) {
        return programService.getProgramById(id);
    }

    @PostMapping
    public Program createProgram(@RequestBody Program program) {
        return programService.saveProgram(program);
    }

    @PutMapping("/{id}")
    public Program updateProgram(@PathVariable Long id, @RequestBody Program program) {
        // Let the service handle the update properly
        return programService.saveProgram(program);
    }

    @DeleteMapping("/{id}")
    public void deleteProgram(@PathVariable Long id) {
        programService.deleteProgram(id);
    }
}
