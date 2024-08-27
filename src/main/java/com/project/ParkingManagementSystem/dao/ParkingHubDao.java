package com.project.ParkingManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ParkingManagementSystem.entity.ParkingHub;
import com.project.ParkingManagementSystem.repo.ParkingHubRepo;

import jakarta.transaction.Transactional;

@Repository
public class ParkingHubDao {
	
	@Autowired
	ParkingHubRepo repo;
	
	public ParkingHub saveHub(ParkingHub hub) {
		return repo.save(hub);
	}
	
	
	public ParkingHub  findByHub(int id) {
		Optional<ParkingHub> hub=repo.findById(id);
		if(hub.isPresent()) {
			return hub.get();
		}
		return null;
	}
	
	public ParkingHub updateHub(ParkingHub hub,int id) {
		ParkingHub oldhub=findByHub(id);
		if(oldhub!=null) {
			hub.setHid(id);
			return repo.save(hub);
		}
		return null;
	}
	
	
	    public ParkingHub deleteHub(int id) {
	        ParkingHub hub = findByHub(id);
	        if (hub != null) {
	            repo.delete(hub);
	       
	            return hub;
	        }
	        return null;
	    }
	
	
	public List<ParkingHub>  findAll(){
		return repo.findAll();
	}

}
