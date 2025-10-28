package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}