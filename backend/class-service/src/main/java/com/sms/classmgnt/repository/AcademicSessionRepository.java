package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.AcademicSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicSessionRepository extends JpaRepository<AcademicSession, Long> {
}