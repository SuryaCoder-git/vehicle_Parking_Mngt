package com.project.ParkingManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ParkingManagementSystem.entity.ParkingHub;

public interface ParkingHubRepo extends JpaRepository<ParkingHub, Integer> {

}
