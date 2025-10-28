package com.sms.classmgnt.service;

import com.sms.classmgnt.model.ClassEntity;
import com.sms.classmgnt.repository.ClassEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassEntityService {

    @Autowired
    private ClassEntityRepository classEntityRepository;

    public List<ClassEntity> getAllClassEntities() {
        return classEntityRepository.findAll();
    }

    public Optional<ClassEntity> getClassEntityById(Long id) {
        return classEntityRepository.findById(id);
    }

    public ClassEntity saveClassEntity(ClassEntity classEntity) {
        return classEntityRepository.save(classEntity);
    }

    public void deleteClassEntity(Long id) {
        classEntityRepository.deleteById(id);
    }
}