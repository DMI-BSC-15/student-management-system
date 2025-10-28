package com.sms.classmgnt.service;

import com.sms.classmgnt.model.AcademicSession;
import com.sms.classmgnt.repository.AcademicSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicSessionService {

    @Autowired
    private AcademicSessionRepository academicSessionRepository;

    public List<AcademicSession> getAllAcademicSessions() {
        return academicSessionRepository.findAll();
    }

    public Optional<AcademicSession> getAcademicSessionById(Long id) {
        return academicSessionRepository.findById(id);
    }

    public AcademicSession saveAcademicSession(AcademicSession academicSession) {
        return academicSessionRepository.save(academicSession);
    }

    public void deleteAcademicSession(Long id) {
        academicSessionRepository.deleteById(id);
    }
}