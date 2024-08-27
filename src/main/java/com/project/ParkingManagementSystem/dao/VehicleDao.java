package com.project.ParkingManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ParkingManagementSystem.entity.Vehicle;
import com.project.ParkingManagementSystem.repo.VehicleRepo;

@Repository
public class VehicleDao {

	@Autowired
	VehicleRepo repo;
	
	
	public Vehicle saveVehicle(Vehicle vehicle) {
		return repo.save(vehicle);
	}
	
	public Vehicle findByid(int id) {
		Optional<Vehicle> v=repo.findById(id);
		if(v.isPresent()) {
			return v.get();
		}
		return null;
		
	}
	
	
	public Vehicle updateVehicle(Vehicle vehicle ,int id) {
		Vehicle oldvehicle=findByid(id);
		if(oldvehicle!=null) {
			vehicle.setVid(id);
			return repo.save(vehicle);
		}
		return null;
	}
	
	
	public Vehicle deleteVehicle(int id) {
		Vehicle v=findByid(id);
		if(v!=null) {
			repo.delete(v);
			return v;
		}
		return null;	
	}
	
	public List<Vehicle>  findAll(){
		return repo.findAll();
	}
	
}
