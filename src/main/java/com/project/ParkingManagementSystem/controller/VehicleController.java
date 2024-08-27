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
import com.project.ParkingManagementSystem.entity.User;
import com.project.ParkingManagementSystem.entity.Vehicle;
import com.project.ParkingManagementSystem.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	VehicleService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Vehicle>> savevehicle(@RequestBody Vehicle vehicle){
		return service.saveVehicle(vehicle);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Vehicle>> findVehicleById(@RequestParam int id){
		return service.findVehicle(id);
	}
	
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Vehicle>> updateVehicle(@RequestBody Vehicle vehicle,@RequestParam int id){
		return service.updateVehicle(vehicle, id);
	}
	
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Vehicle>> deleteVehicle(@RequestParam int id){
		return service.deleteVehicle(id);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Vehicle>>  findAll(){
		return service.findAll();
	}
	
	@GetMapping("/findUserbasedOnVid")
	public ResponseEntity<ResponseStructure<User>> findUserbasedOnVehicleId(@RequestParam int vid ){
		return service.findUserbasedVehicleId(vid);
	}
	
	
	@PutMapping("/assignSlotToVehicle")
	public ResponseEntity<ResponseStructure<Vehicle>> assignSlotToVehicle(@RequestParam int vid,@RequestParam int sid){
		return service.assignvehicleToSlot(vid, sid);
	}
	
	

}
