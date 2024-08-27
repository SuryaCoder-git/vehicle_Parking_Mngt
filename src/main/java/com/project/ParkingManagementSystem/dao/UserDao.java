package com.project.ParkingManagementSystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.project.ParkingManagementSystem.entity.Feedback;
import com.project.ParkingManagementSystem.entity.User;
import com.project.ParkingManagementSystem.entity.Vehicle;
import com.project.ParkingManagementSystem.repo.UserRepo;

@Repository
public class UserDao {
	
	@Autowired
	UserRepo repo;
	
	public User SaveUser(User user) {
		return repo.save(user);
	}
	
	public User FindByid(int id) {
		Optional<User> u=repo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		return null;
	}
	
	public User deleteUser(int id) {
		User u=FindByid(id);
		if(u!=null) {
			 repo.delete(u);
			 return u;
		}
		return null;
		
	}
	
	public User updateUser(User user, int id) {
	    User oldUser = FindByid(id);
	    if (oldUser != null) {
	        oldUser.setEmail(user.getEmail());
	        oldUser.setNotification(user.getNotification());
	        oldUser.setGender(user.getGender());
	        oldUser.setUname(user.getUname());
	        oldUser.setNumber(user.getNumber());

	        // Handle vehicles collection
	        if (user.getVehicles() != null) {
	            oldUser.getVehicles().clear();  // Clear existing vehicles
	            for (Vehicle vehicle : user.getVehicles()) {
	                oldUser.getVehicles().add(vehicle);  // Add new vehicles
	                vehicle.setUser(oldUser);  // Ensure bidirectional update
	            }
	        } else {
	            oldUser.getVehicles().clear();  // Clear vehicles if null
	        }

	        // Handle feedbacks collection
	        if (user.getFeedbacks() != null) {
	            oldUser.getFeedbacks().clear();  // Clear existing feedbacks
	            for (Feedback feedback : user.getFeedbacks()) {
	                oldUser.getFeedbacks().add(feedback);  // Add new feedbacks
	                feedback.setUser(oldUser);  // Ensure bidirectional update
	            }
	        } else {
	            oldUser.getFeedbacks().clear();  // Clear feedbacks if null
	        }

	        return repo.save(oldUser);
	    }
	    return null;
	}



	
	
	public List<User>  findAll(){
		return repo.findAll();
	}
	

}
