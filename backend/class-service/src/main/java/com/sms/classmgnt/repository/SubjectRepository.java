package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}