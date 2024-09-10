package com.project.ParkingManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.FeedbackDao;
import com.project.ParkingManagementSystem.dao.ParkingHubDao;
import com.project.ParkingManagementSystem.dao.ParkingSlotdao;
import com.project.ParkingManagementSystem.entity.Feedback;
import com.project.ParkingManagementSystem.entity.ParkingHub;
import com.project.ParkingManagementSystem.entity.ParkingSlot;
import com.project.ParkingManagementSystem.repo.FeedbackRepo;
import com.project.ParkingManagementSystem.repo.ParkingHubRepo;
import com.project.ParkingManagementSystem.repo.ParkingSlotRepo;

import jakarta.transaction.Transactional;

@Service
public class ParkingHubService {

	@Autowired
	ParkingSlotdao sdao;


	@Autowired
	ParkingHubDao dao;
	
	@Autowired
	FeedbackDao fdao;
	
	@Autowired
	FeedbackRepo frepo;

	@Autowired
	ParkingHubRepo repo;
	
	@Autowired
	ParkingSlotRepo slotrepo;

	@Autowired
	ResponseStructure<ParkingHub> structure;

	@Autowired
	ResponseStructure<ParkingSlot>  slotstructure;

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


	public ResponseEntity<ResponseStructure<ParkingHub>> AssignHubToSlot(int hid,int sid){
		ParkingHub hub=dao.findByHub(hid);
		ParkingSlot slot=sdao.findById(sid);
		if(hub!=null) {
			if(slot!=null) {
				List<ParkingSlot> hubList=hub.getSlots();
				if(hubList!=null) {
					hubList=new ArrayList<ParkingSlot>();
				}
				hubList.add(slot);
				hub.setSlots(hubList);
				slot.setParkingHub(hub);
				repo.save(hub);
				slotrepo.save(slot);				slotstructure.setData(slot);				slotstructure.setMessage("assigned parkingSlot to ParkingHub successfully");				slotstructure.setStatus(HttpStatus.ACCEPTED.value());
				return new ResponseEntity<ResponseStructure<ParkingHub>>(structure,HttpStatus.ACCEPTED);   
			}
		}
		return  null;
	}
	
	
	
	public ResponseEntity<ResponseStructure<ParkingHub>>  AssignHubToFeedback(int hid,int fid){
		ParkingHub hub=dao.findByHub(hid);
		Feedback fb=fdao.findById(fid);
		
		if(hub!=null) {
			if(fb!=null) {
				List<Feedback> feedlist=hub.getFeedbacks();
				if(feedlist==null) {
					feedlist=new ArrayList<Feedback>();
				}
				feedlist.add(fb);
				hub.setFeedbacks(feedlist);
				fb.setParkingHub(hub);
				repo.save(hub);
				frepo.save(fb);
				
				structure.setData(hub);
				structure.setMessage("Assigned parkingHub to ParkingSlot successfully");
				structure.setStatus(HttpStatus.ACCEPTED.value());
				return new ResponseEntity<ResponseStructure<ParkingHub>>(structure,HttpStatus.ACCEPTED);
			}
		}
		return null;
	}




}
