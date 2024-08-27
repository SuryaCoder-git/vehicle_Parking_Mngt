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
import com.project.ParkingManagementSystem.entity.ParkingHub;
import com.project.ParkingManagementSystem.service.ParkingHubService;

@RestController
@RequestMapping("/hub")
public class ParkingHubController {
	
	@Autowired
	ParkingHubService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ParkingHub>> saveHub(@RequestBody ParkingHub hub){
		return service.saveHub(hub);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ParkingHub>>  findHubByid(@RequestParam int id){
		return service.FindHub(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ParkingHub>>  updateHub(@RequestBody ParkingHub hub,int id){
		return service.updateHub(hub, id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ParkingHub>> deletehub(@RequestParam int id){
		return service.deleteHub(id);
	}
	
	
	@GetMapping("/findall")
	public ResponseEntity<List<ParkingHub>>  findAll(){
		return service.findAll();
	}
	
	

}
