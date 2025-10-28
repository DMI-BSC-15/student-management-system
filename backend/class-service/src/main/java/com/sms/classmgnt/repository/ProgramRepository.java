package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}