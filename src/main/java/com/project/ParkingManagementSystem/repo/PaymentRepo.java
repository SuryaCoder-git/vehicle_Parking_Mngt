package com.project.ParkingManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ParkingManagementSystem.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
