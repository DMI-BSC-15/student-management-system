package com.sms.classmgnt.service;

import com.sms.classmgnt.model.Timetable;
import com.sms.classmgnt.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalTime;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }

    public Optional<Timetable> getTimetableById(Long id) {
        return timetableRepository.findById(id);
    }

    public Timetable saveTimetable(Timetable timetable) {
        validateNoClash(timetable);
        return timetableRepository.save(timetable);
    }

    public void deleteTimetable(Long id) {
        timetableRepository.deleteById(id);
    }

    private void validateNoClash(Timetable candidate) {
        if (candidate == null) {
            throw new IllegalArgumentException("Timetable cannot be null");
        }

        if (candidate.getDayOfWeek() == null || candidate.getStartTime() == null || candidate.getEndTime() == null) {
            throw new IllegalArgumentException("Day, startTime, and endTime are required");
        }

        LocalTime candidateStart = parseTime(candidate.getStartTime());
        LocalTime candidateEnd = parseTime(candidate.getEndTime());

        if (!candidateStart.isBefore(candidateEnd)) {
            throw new IllegalArgumentException("startTime must be before endTime");
        }

        Long candidateId = candidate.getId();
        String day = candidate.getDayOfWeek();

        // Check room clashes
        if (candidate.getRoom() != null && candidate.getRoom().getId() != null) {
            List<Timetable> sameRoom = timetableRepository.findByDayOfWeekAndRoom_Id(day, candidate.getRoom().getId());
            ensureNoOverlap(candidateId, candidateStart, candidateEnd, sameRoom, "room");
        }

        // Check class clashes
        if (candidate.getClassEntity() != null && candidate.getClassEntity().getId() != null) {
            List<Timetable> sameClass = timetableRepository.findByDayOfWeekAndClassEntity_Id(day, candidate.getClassEntity().getId());
            ensureNoOverlap(candidateId, candidateStart, candidateEnd, sameClass, "class");
        }

        // Check subject clashes
        if (candidate.getSubject() != null && candidate.getSubject().getId() != null) {
            List<Timetable> sameSubject = timetableRepository.findByDayOfWeekAndSubject_Id(day, candidate.getSubject().getId());
            ensureNoOverlap(candidateId, candidateStart, candidateEnd, sameSubject, "subject");
        }

        // Check instructor clashes (through subject)
        if (candidate.getSubject() != null && candidate.getSubject().getInstructor() != null && candidate.getSubject().getInstructor().getId() != null) {
            List<Timetable> sameInstructor = timetableRepository.findByDayOfWeekAndSubject_Instructor_Id(day, candidate.getSubject().getInstructor().getId());
            ensureNoOverlap(candidateId, candidateStart, candidateEnd, sameInstructor, "instructor");
        }
    }

    private void ensureNoOverlap(Long candidateId, LocalTime candidateStart, LocalTime candidateEnd, List<Timetable> existingItems, String dimension) {
        for (Timetable existing : existingItems) {
            if (candidateId != null && existing.getId() != null && existing.getId().equals(candidateId)) {
                continue; // skip self when updating
            }

            LocalTime existingStart = parseTime(existing.getStartTime());
            LocalTime existingEnd = parseTime(existing.getEndTime());

            if (timesOverlap(candidateStart, candidateEnd, existingStart, existingEnd)) {
                throw new IllegalArgumentException("Clash detected on " + dimension + " with existing timetable ID " + existing.getId());
            }
        }
    }

    private boolean timesOverlap(LocalTime aStart, LocalTime aEnd, LocalTime bStart, LocalTime bEnd) {
        // Overlap if each starts before the other ends. Back-to-back is allowed.
        return aStart.isBefore(bEnd) && bStart.isBefore(aEnd);
    }

    private LocalTime parseTime(String time) {
        try {
            return LocalTime.parse(time);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format, expected HH:mm: " + time);
        }
    }
}