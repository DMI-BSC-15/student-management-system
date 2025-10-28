package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}