package com.project.ParkingManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ParkingManagementSystem.entity.ParkingSlot;

public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Integer> {

}
