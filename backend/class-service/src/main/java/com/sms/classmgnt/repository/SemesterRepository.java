package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}