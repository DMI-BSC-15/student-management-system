package com.sms.classmgnt.controller;

import com.sms.classmgnt.model.ClassEntity;
import com.sms.classmgnt.service.ClassEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassEntityController {

    @Autowired
    private ClassEntityService classEntityService;

    @GetMapping
    public List<ClassEntity> getAllClassEntities() {
        return classEntityService.getAllClassEntities();
    }

    @GetMapping("/{id}")
    public Optional<ClassEntity> getClassEntityById(@PathVariable Long id) {
        return classEntityService.getClassEntityById(id);
    }

    @PostMapping
    public ClassEntity createClassEntity(@RequestBody ClassEntity classEntity) {
        return classEntityService.saveClassEntity(classEntity);
    }

    @PutMapping("/{id}")
    public ClassEntity updateClassEntity(@PathVariable Long id, @RequestBody ClassEntity classEntity) {
        // Let the service handle the update properly
        return classEntityService.saveClassEntity(classEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteClassEntity(@PathVariable Long id) {
        classEntityService.deleteClassEntity(id);
    }
}