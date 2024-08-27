package com.project.ParkingManagementSystem.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
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
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.entity.User;
import com.project.ParkingManagementSystem.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>>  saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> finduserById(@RequestParam int id){
		return service.findUserById(id);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updatedUser(@RequestBody User user,@RequestParam int id){
		return service.UpdateUser(user, id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> deletUser(@RequestParam int id){
		return service.deleteUser(id)	;}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAll(){
		return service.findAll();
	}
	
	
	@PutMapping("/assignvehicletouser")
	public ResponseEntity<ResponseStructure<User>> AssignVehicleToUser(@RequestParam int uid,@RequestParam int vid){
		return service.AssignVehicleYoUser(uid, vid);
	}
	
	
	@PutMapping("/assignFeedbacktouser")
	public ResponseEntity<ResponseStructure<User>> AssignFeedbackToUser(@RequestParam int uid,@RequestParam int fid){
		return service.AssignFeedbackToUser(uid, fid);
	}
	
	
	@PutMapping("/assignNotificationtouser")
	public ResponseEntity<ResponseStructure<User>> AssignNotificationToUser(@RequestParam int uid,@RequestParam int nid){
		return service.AssignNotificationToUser(uid, nid);
	}
	
	
	
}
