package com.project.ParkingManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ParkingManagementSystem.entity.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {

}
