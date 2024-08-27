package com.project.ParkingManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.FeedbackDao;
import com.project.ParkingManagementSystem.entity.Feedback;
import com.project.ParkingManagementSystem.entity.Payment;

@Service
public class FeedbackService {

	@Autowired
	FeedbackDao dao;
	
	@Autowired
	ResponseStructure<Feedback> structure; 
	
	
	public ResponseEntity<ResponseStructure<Feedback>>  SaveFeed(Feedback feed){
		Feedback fb=dao.savefeed(feed);
		if(fb!=null) {
			structure.setData(fb);
			structure.setMessage("feedback message stored successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Feedback>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	
	public ResponseEntity<ResponseStructure<Feedback>>  UpdateFeed(Feedback feed ,int id){
		Feedback fb=dao.updatefeed(feed, id);
		if(fb!=null) {
			structure.setData(fb);
			structure.setMessage("feedback message updated successfully");
			structure.setStatus(HttpStatus.IM_USED.value());
			return new ResponseEntity<ResponseStructure<Feedback>>(structure,HttpStatus.IM_USED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Feedback>>  deletefeed(int id){
		Feedback fb=dao.deleteFeed(id);
		if(fb!=null) {
			structure.setData(fb);
			structure.setMessage("feedback message Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Feedback>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Feedback>>  Findfeed(int id){
		Feedback fb=dao.findById(id);
		if(fb!=null) {
			structure.setData(fb);
			structure.setMessage("feedback message retrived successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Feedback>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	public ResponseEntity<List<Feedback>>FindAll(){
		return new ResponseEntity<List<Feedback>>(dao.findAll(),HttpStatus.FOUND);
	}
	
	
}
