package com.project.ParkingManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ParkingManagementSystem.entity.Location;
import com.project.ParkingManagementSystem.repo.LocationRepo;

@Repository
public class LocationDao {
	
	@Autowired
	LocationRepo repo;
	
	public Location savelocation(Location loc) {
		return repo.save(loc);
	}
	
	public Location findById(int id) {
		Optional<Location> loc=repo.findById(id);
		if(loc.isPresent()) {
			return loc.get();
		}
		return null;
	}
	
	public Location updatelocation(Location loc,int id) {
		Location oldloc=findById(id);
		if(oldloc!=null) {
			loc.setLid(id);
			return repo.save(loc);
		}
		return null;
	}
	
	
	public Location deleteLocation(int id) {
		Location loc=findById(id);
		if(loc!=null) {
			repo.delete(loc);
			return loc;
		}
		return null;
	}
	
	
	
	public List<Location> findall(){
		return repo.findAll();
	}

}
