package com.project.ParkingManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ParkingManagementSystem.entity.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {

}
