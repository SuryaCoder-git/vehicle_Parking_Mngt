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
import com.project.ParkingManagementSystem.entity.Location;
import com.project.ParkingManagementSystem.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	LocationService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Location>> saveLocation(@RequestBody Location loc){
		return service.savelocation(loc);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Location>>  findlocationById(@RequestParam int id){
		return service.findlocation(id);
	}
	
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Location>>  updatelocation(@RequestBody Location loc,@RequestParam int id){
		return service.updatelocation(loc, id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Location>>  deletelocation(@RequestParam int id){
		return service.deletelocation(id);
	}
    
	
	@GetMapping("/findall")
	public ResponseEntity<List<Location>>  findAll(){
		return service.findAll();
	}
	
}
