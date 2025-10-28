package com.sms.classmgnt.service;

import com.sms.classmgnt.model.Allocation;
import com.sms.classmgnt.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    public Optional<Allocation> getAllocationById(Long id) {
        return allocationRepository.findById(id);
    }

    public Allocation saveAllocation(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    public void deleteAllocation(Long id) {
        allocationRepository.deleteById(id);
    }
}