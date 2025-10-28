package com.sms.classmgnt.controller;

import com.sms.classmgnt.model.Allocation;
import com.sms.classmgnt.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/allocations")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @GetMapping
    public List<Allocation> getAllAllocations() {
        return allocationService.getAllAllocations();
    }

    @GetMapping("/{id}")
    public Optional<Allocation> getAllocationById(@PathVariable Long id) {
        return allocationService.getAllocationById(id);
    }

    @PostMapping
    public Allocation createAllocation(@RequestBody Allocation allocation) {
        return allocationService.saveAllocation(allocation);
    }

    @PutMapping("/{id}")
    public Allocation updateAllocation(@PathVariable Long id, @RequestBody Allocation allocation) {
        // Let the service handle the update properly
        return allocationService.saveAllocation(allocation);
    }

    @DeleteMapping("/{id}")
    public void deleteAllocation(@PathVariable Long id) {
        allocationService.deleteAllocation(id);
    }
}