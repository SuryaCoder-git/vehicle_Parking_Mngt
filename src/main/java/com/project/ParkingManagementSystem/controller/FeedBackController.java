package com.project.ParkingManagementSystem.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.entity.Feedback;
import com.project.ParkingManagementSystem.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
	
	@Autowired
	FeedbackService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Feedback>>  saveFeed(@RequestBody Feedback feed)
	{
		return service.SaveFeed(feed);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Feedback>>  updateFeed(@RequestBody Feedback feed,@RequestParam int id){
		return service.UpdateFeed(feed, id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Feedback>> deleteFeed(@RequestParam int id){
		return service.deletefeed(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Feedback>>  findFeed(@RequestParam int id){
		return service.Findfeed(id);
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Feedback>> FindAll(){
		return service.FindAll();
	}
	
	
	
}
