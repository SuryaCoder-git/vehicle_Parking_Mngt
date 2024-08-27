package com.project.ParkingManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ParkingManagementSystem.entity.Feedback;
import com.project.ParkingManagementSystem.repo.FeedbackRepo;

@Repository
public class FeedbackDao {

	@Autowired
	FeedbackRepo repo;
	
	
	public Feedback savefeed(Feedback feed) {
		return repo.save(feed);
	}
	
	public Feedback findById(int id) {
		Optional<Feedback> feed=repo.findById(id);
		if(feed.isPresent()) {
			return feed.get();
		}
		return null;
	}
	
	public Feedback updatefeed(Feedback feed,int id) {
		Feedback oldfeed=findById(id);
		if(oldfeed!=null) {
			feed.setFid(id);
			return repo.save(feed);
		}
		return null;	
	}
	
	
	public Feedback deleteFeed(int id) {
		Feedback oldfeed=findById(id);
		if(oldfeed!=null) {
			repo.delete(oldfeed);
			return oldfeed;
		}
		return null;
	}
	
	
	public List<Feedback> findAll(){
		return repo.findAll();
	}
	
	
	
	
	
	
	
	
}
