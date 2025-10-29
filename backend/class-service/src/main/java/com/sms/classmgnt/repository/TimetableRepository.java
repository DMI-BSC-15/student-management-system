package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    java.util.List<Timetable> findByDayOfWeekAndRoom_Id(String dayOfWeek, Long roomId);
    java.util.List<Timetable> findByDayOfWeekAndClassEntity_Id(String dayOfWeek, Long classEntityId);
    java.util.List<Timetable> findByDayOfWeekAndSubject_Id(String dayOfWeek, Long subjectId);
    java.util.List<Timetable> findByDayOfWeekAndSubject_Instructor_Id(String dayOfWeek, Long instructorId);
}