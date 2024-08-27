package com.project.ParkingManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.entity.Payment;
import com.project.ParkingManagementSystem.service.paymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	paymentService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Payment>>  savePayment(@RequestBody  Payment payment){
		return service.savePayment(payment);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Payment>> findPayment(@RequestParam int id){
		return service.findPayment(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Payment>> updatePayment(@RequestBody Payment pay,@RequestParam int id){
		return service.UpdatePayment(pay, id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Payment>> deletePayment(@RequestParam int id){
		return service.deletePayment(id);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Payment>> findAll(){
		return service.FindAll();
	}
	

}
