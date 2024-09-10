package com.project.ParkingManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.LocationDao;
import com.project.ParkingManagementSystem.dao.ParkingHubDao;
import com.project.ParkingManagementSystem.entity.Location;
import com.project.ParkingManagementSystem.entity.ParkingHub;
import com.project.ParkingManagementSystem.exception.LocationNotSaved;
import com.project.ParkingManagementSystem.repo.LocationRepo;
import com.project.ParkingManagementSystem.repo.ParkingHubRepo;

@Service
public class LocationService {


	@Autowired
	LocationDao dao;

	@Autowired
	ParkingHubDao hdao;

	@Autowired
	LocationRepo repo;

	@Autowired
	ParkingHubRepo hrepo;

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
	  throw new LocationNotSaved("Location not Saved");
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


	public ResponseEntity<ResponseStructure<Location>>  AssignlocationToHub(int lid,int hid){
		Location loc=dao.findById(lid);
		ParkingHub hub=hdao.findByHub(hid);
		if(loc!=null) {
			if(hub!=null) {
				if(hub.getLocation()==null) {
					hub.setLocation(loc);
					List<ParkingHub> HubList=loc.getHubs();
					if(HubList!=null) {
						HubList=new ArrayList<ParkingHub>();
					}
					HubList.add(hub);
					loc.setHubs(HubList);
					dao.savelocation(loc);
					hdao.saveHub(hub);
					structure.setData(loc);
					structure.setMessage("Assigned Location to Parkinghub succesfully");
					structure.setStatus(HttpStatus.ACCEPTED.value());
					return new ResponseEntity<ResponseStructure<Location>>(structure,HttpStatus.ACCEPTED);	
				}
			}
		}
		return null;
	}



}
