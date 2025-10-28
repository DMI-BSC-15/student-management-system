package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}