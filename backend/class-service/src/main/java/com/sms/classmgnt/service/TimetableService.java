package com.sms.classmgnt.service;

import com.sms.classmgnt.model.Timetable;
import com.sms.classmgnt.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return timetableRepository.save(timetable);
    }

    public void deleteTimetable(Long id) {
        timetableRepository.deleteById(id);
    }
}