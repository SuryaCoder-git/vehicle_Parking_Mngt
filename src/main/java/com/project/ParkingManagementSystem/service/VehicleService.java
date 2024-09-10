package com.project.ParkingManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.ParkingSlotdao;
import com.project.ParkingManagementSystem.dao.VehicleDao;
import com.project.ParkingManagementSystem.entity.ParkingSlot;
import com.project.ParkingManagementSystem.entity.User;
import com.project.ParkingManagementSystem.entity.Vehicle;
import com.project.ParkingManagementSystem.exception.ParkingSlotNotFound;
import com.project.ParkingManagementSystem.exception.VehicleHaveSlot;
import com.project.ParkingManagementSystem.exception.VehicleNotDeleted;
import com.project.ParkingManagementSystem.exception.VehicleNotFound;
import com.project.ParkingManagementSystem.exception.VehicleNotSaved;
import com.project.ParkingManagementSystem.exception.VehicleNotUpdated;
import com.project.ParkingManagementSystem.repo.VehicleRepo;

@Service
public class VehicleService {

	@Autowired
	VehicleDao dao;

	@Autowired
	ParkingSlotdao sdao;

	@Autowired
	ResponseStructure<Vehicle>  structure;

	@Autowired
	ResponseStructure<User> userstructure;


	public ResponseEntity<ResponseStructure<Vehicle>>  saveVehicle(Vehicle vehicle){
		Vehicle ve=dao.saveVehicle(vehicle);
		if(ve!=null) {
			structure.setData(ve);
			structure.setMessage("vehicle data stored successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Vehicle>>(structure,HttpStatus.ACCEPTED);
		}
		throw new VehicleNotSaved("vehicle not Saved");
	}

	public ResponseEntity<ResponseStructure<Vehicle>>  findVehicle(int id){
		Vehicle ve=dao.findByid(id);
		if(ve!=null) {
			structure.setData(ve);
			structure.setMessage("vehicle data retrieved successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Vehicle>>(structure,HttpStatus.FOUND);
		}
		throw new VehicleNotFound("Vehicle not Found");	
	}


	public ResponseEntity<ResponseStructure<Vehicle>>  updateVehicle(Vehicle vehicle,int id){
		Vehicle ve=dao.updateVehicle(vehicle, id);
		if(ve!=null) {
			structure.setData(ve);
			structure.setMessage("vehicle data updated successfully");
			structure.setStatus(HttpStatus.IM_USED.value());
			return new ResponseEntity<ResponseStructure<Vehicle>>(structure,HttpStatus.IM_USED);
		}
		throw new VehicleNotUpdated("vehicle not Updated");
	}


	public ResponseEntity<ResponseStructure<Vehicle>>  deleteVehicle(int id){
		Vehicle ve=dao.deleteVehicle(id);
		if(ve!=null) {
			structure.setData(ve);
			structure.setMessage("vehicle data deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Vehicle>>(structure,HttpStatus.OK);
		}
		throw new VehicleNotDeleted("vehicle not deleted");	
	}

	public ResponseEntity<List<Vehicle>> findAll(){
		return new ResponseEntity<List<Vehicle>>(dao.findAll(),HttpStatus.FOUND);
	}


	public ResponseEntity<ResponseStructure<User>>  findUserbasedVehicleId(int vid){
		Vehicle veh=dao.findByid(vid);
		if(veh!=null) {
			User user=veh.getUser();
			userstructure.setData(user);
			userstructure.setMessage("user data retrived successfully");
			userstructure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<User>>(userstructure,HttpStatus.ACCEPTED);
		}
		throw new VehicleNotFound("vehicle not found");
	}


	public ResponseEntity<ResponseStructure<Vehicle>> assignvehicleToSlot(int vid,int sid){
		Vehicle ve=dao.findByid(vid);
		ParkingSlot slot=sdao.findById(sid);
		if(ve!=null) {
			if(slot!=null) {
				if(ve.getParkingSlot()==null) {
					ve.setParkingSlot(slot);
					dao.saveVehicle(ve);
					structure.setData(ve);
					structure.setMessage("parkingSlot Assigned to vehicle successfully");
					structure.setStatus(HttpStatus.IM_USED.value());
					return new ResponseEntity<ResponseStructure<Vehicle>>(structure,HttpStatus.IM_USED);
				}
				throw new VehicleHaveSlot("Vehicle Have ParkingSlot");
			}
			throw new ParkingSlotNotFound("Parking Slot Not Found");
		}
		throw new VehicleNotFound("Vehicle Not Found");
	}











}
