package com.project.ParkingManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.entity.Notification;
import com.project.ParkingManagementSystem.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	NotificationService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Notification>>  savenotification(@RequestBody Notification notify){
		return service.saveNotification(notify);
	}
	
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Notification>>  updatenotification(@RequestBody Notification notify,@RequestParam int id){
		return service.updatedNotification(notify, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Notification>>   findNotification(@RequestParam int id){
		return service.findNotification(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Notification>>  deleteNotification(@RequestParam int id){
		return service.deleteNotification(id);
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Notification>>  findAll(){
		return service.findAll();
	}

}
