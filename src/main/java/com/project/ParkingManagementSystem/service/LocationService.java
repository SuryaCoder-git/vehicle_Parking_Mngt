package com.project.ParkingManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.LocationDao;
import com.project.ParkingManagementSystem.entity.Location;

@Service
public class LocationService {
	
	
	@Autowired
	LocationDao dao;
	
	
	@Autowired
	ResponseStructure<Location> structure;

	
	public ResponseEntity<ResponseStructure<Location>>  savelocation(Location loc){
		Location location=dao.savelocation(loc);
		if(location!=null) {
			structure.setData(location);
			structure.setMessage("location data stored successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Location>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	
	public ResponseEntity<ResponseStructure<Location>>  findlocation(int id){
		Location location=dao.findById(id);
		if(location!=null) {
			structure.setData(location);
			structure.setMessage("location data retrieved successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Location>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Location>>  updatelocation(Location loc,int id){
		Location location=dao.updatelocation(loc, id);
		if(location!=null) {
			structure.setData(location);
			structure.setMessage("location data updated successfully");
			structure.setStatus(HttpStatus.IM_USED.value());
			return new ResponseEntity<ResponseStructure<Location>>(structure,HttpStatus.IM_USED);
		}
		return null;
	}
	
	
	
	public ResponseEntity<ResponseStructure<Location>>  deletelocation(int id){
		Location location=dao.deleteLocation(id);
		if(location!=null) {
			structure.setData(location);
			structure.setMessage("location data deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Location>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	
	
	public ResponseEntity<List<Location>>  findAll(){
		return new ResponseEntity<List<Location>>(dao.findall(),HttpStatus.FOUND);
		
	}
	
	
	
}
