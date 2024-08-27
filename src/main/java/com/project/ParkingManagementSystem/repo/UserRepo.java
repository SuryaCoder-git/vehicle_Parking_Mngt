package com.project.ParkingManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ParkingManagementSystem.entity.User;

public interface UserRepo  extends JpaRepository<User, Integer>{

}
