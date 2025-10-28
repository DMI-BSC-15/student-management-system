package com.sms.classmgnt.service;

import com.sms.classmgnt.model.Semester;
import com.sms.classmgnt.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Optional<Semester> getSemesterById(Long id) {
        return semesterRepository.findById(id);
    }

    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    public void deleteSemester(Long id) {
        semesterRepository.deleteById(id);
    }
}