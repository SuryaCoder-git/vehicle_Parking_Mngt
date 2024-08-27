package com.project.ParkingManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ParkingManagementSystem.entity.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

}
