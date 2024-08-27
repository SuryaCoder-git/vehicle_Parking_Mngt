package com.project.ParkingManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.ParkingSlotdao;
import com.project.ParkingManagementSystem.entity.ParkingHub;
import com.project.ParkingManagementSystem.entity.ParkingSlot;
import com.project.ParkingManagementSystem.repo.ParkingSlotRepo;

@Service
public class ParkingSlotService {
	
	@Autowired
	ParkingSlotRepo repo;
	
	@Autowired
	ParkingSlotdao dao;
	
	@Autowired
	ResponseStructure<ParkingSlot> structure;
	
	
	public ResponseEntity<ResponseStructure<ParkingSlot>>  saveSlot(ParkingSlot slot){
		ParkingSlot saveSlot=dao.saveslot(slot);
		if(saveSlot!=null) {
			structure.setData(saveSlot);
			structure.setMessage("parking slot data stored successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<ParkingSlot>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ParkingSlot>>  findSlot(int id){
		ParkingSlot saveSlot=dao.findById(id);
		if(saveSlot!=null) {
			structure.setData(saveSlot);
			structure.setMessage("parking slot data Retrived successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<ParkingSlot>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ParkingSlot>>  UpdateSlot(ParkingSlot slot,int id){
		ParkingSlot saveSlot=dao.updateSlot(slot, id);
		if(saveSlot!=null) {
			structure.setData(saveSlot);
			structure.setMessage("parking slot data updated successfully");
			structure.setStatus(HttpStatus.IM_USED.value());
			return new ResponseEntity<ResponseStructure<ParkingSlot>>(structure,HttpStatus.IM_USED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ParkingSlot>>  deleteSlot(int id){
		ParkingSlot saveSlot=dao.deleteSlot(id);
		if(saveSlot!=null) {
			structure.setData(saveSlot);
			structure.setMessage("parking slot data deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ParkingSlot>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	
	public ResponseEntity<List<ParkingSlot>>  findAll(){
		return new ResponseEntity<List<ParkingSlot>>(dao.findAll(),HttpStatus.FOUND);
	}
	
	
	

}
