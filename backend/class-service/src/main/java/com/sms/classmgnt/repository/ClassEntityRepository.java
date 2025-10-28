package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassEntityRepository extends JpaRepository<ClassEntity, Long> {
}