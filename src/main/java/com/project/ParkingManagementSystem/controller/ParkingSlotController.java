package com.project.ParkingManagementSystem.controller;

import java.util.List;

import org.hibernate.annotations.processing.Find;
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
import com.project.ParkingManagementSystem.entity.ParkingSlot;
import com.project.ParkingManagementSystem.service.ParkingSlotService;

@RestController
@RequestMapping("/slot")
public class ParkingSlotController {
	
	@Autowired
	ParkingSlotService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ParkingSlot>> saveslot(@RequestBody ParkingSlot slot){
		return service.saveSlot(slot);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ParkingSlot>> findSlot(@RequestParam int id){
		return service.findSlot(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ParkingSlot>> updateSlot(@RequestBody ParkingSlot slot,@RequestParam int id){
		return service.UpdateSlot(slot, id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ParkingSlot>> deleteSlot(@RequestParam int id){
		return service.deleteSlot(id);
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ParkingSlot>> findAll(){
		return service.findAll();
	}
	
	
	@PutMapping("/assignedSlotToNotify")
	public ResponseEntity<ResponseStructure<ParkingSlot>> AssignedSlotToNotify(@RequestParam int sid,@RequestParam int nid){
		return service.AssignedSlotToNotify(sid, nid);
	}
	
	

}
