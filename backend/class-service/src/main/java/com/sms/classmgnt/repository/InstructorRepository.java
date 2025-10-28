package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}