package com.sms.classmgnt.repository;

import com.sms.classmgnt.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}