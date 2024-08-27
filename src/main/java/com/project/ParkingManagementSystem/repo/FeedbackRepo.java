package com.project.ParkingManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ParkingManagementSystem.entity.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

}
