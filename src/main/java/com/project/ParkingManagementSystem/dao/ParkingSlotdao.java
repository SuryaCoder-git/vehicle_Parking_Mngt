package com.project.ParkingManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ParkingManagementSystem.entity.ParkingHub;
import com.project.ParkingManagementSystem.entity.ParkingSlot;
import com.project.ParkingManagementSystem.repo.ParkingSlotRepo;

@Repository
public class ParkingSlotdao {

	
	@Autowired
	ParkingSlotRepo repo;
	
	public ParkingSlot saveslot(ParkingSlot  slot) {
		return repo.save(slot);
	}
	
	
	public ParkingSlot findById(int id) {
		Optional<ParkingSlot> slot= repo.findById(id);
		if(slot.isPresent()) {
			return slot.get();
		}
		return null;
	}
	
	
	public ParkingSlot  updateSlot(ParkingSlot slot,int id) {
		ParkingSlot oldSlot=findById(id);
		if(oldSlot!=null) {
			slot.setSlotId(id);
			return repo.save(slot);
		}
		return null;
	}
	
	public ParkingSlot deleteSlot(int id) {
		ParkingSlot slot=findById(id);
		if(slot!=null) {
			repo.delete(slot);
			return slot;
		}
		return null;
	}
	
	
	
	public List<ParkingSlot> findAll(){
		return repo.findAll();
	}
}
