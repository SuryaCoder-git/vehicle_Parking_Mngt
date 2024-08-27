package com.project.ParkingManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.ParkingHubDao;
import com.project.ParkingManagementSystem.entity.ParkingHub;

import jakarta.transaction.Transactional;

@Service
public class ParkingHubService {
	
	@Autowired
	ParkingHubDao dao;
	
	@Autowired
	ResponseStructure<ParkingHub> structure;
	
	public ResponseEntity<ResponseStructure<ParkingHub>>  saveHub(ParkingHub hub){
		ParkingHub parkinghub=dao.saveHub(hub);
		if(parkinghub!=null) {
			structure.setData(parkinghub);
			structure.setMessage("parking hub data stored successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<ParkingHub>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ParkingHub>>  FindHub(int id){
		ParkingHub parkinghub=dao.findByHub(id);
		if(parkinghub!=null) {
			structure.setData(parkinghub);
			structure.setMessage("parking hub data retrived successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<ParkingHub>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ParkingHub>>  updateHub(ParkingHub hub,int id){
		ParkingHub parkinghub=dao.updateHub(hub, id);
		if(parkinghub!=null) {
			structure.setData(parkinghub);
			structure.setMessage("parking hub data updated successfully");
			structure.setStatus(HttpStatus.IM_USED.value());
			return new ResponseEntity<ResponseStructure<ParkingHub>>(structure,HttpStatus.IM_USED);
		}
		return null;
	}
	
	 @Transactional
	public ResponseEntity<ResponseStructure<ParkingHub>>  deleteHub(int id){
		ParkingHub parkinghub=dao.deleteHub(id);
		if(parkinghub!=null) {
			structure.setData(parkinghub);
			structure.setMessage("parking hub data deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ParkingHub>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	
	public ResponseEntity<List<ParkingHub>>  findAll(){
		return new ResponseEntity<List<ParkingHub>>(dao.findAll(),HttpStatus.FOUND);
	}
	

}
