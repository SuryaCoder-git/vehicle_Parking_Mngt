package com.project.ParkingManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.FeedbackDao;
import com.project.ParkingManagementSystem.dao.NotificationDao;
import com.project.ParkingManagementSystem.dao.UserDao;
import com.project.ParkingManagementSystem.dao.VehicleDao;
import com.project.ParkingManagementSystem.entity.Feedback;
import com.project.ParkingManagementSystem.entity.Notification;
import com.project.ParkingManagementSystem.entity.User;
import com.project.ParkingManagementSystem.entity.Vehicle;
import com.project.ParkingManagementSystem.repo.FeedbackRepo;
import com.project.ParkingManagementSystem.repo.NotificationRepo;
import com.project.ParkingManagementSystem.repo.UserRepo;
import com.project.ParkingManagementSystem.repo.VehicleRepo;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	@Autowired
	FeedbackDao fdao;

	@Autowired
	UserRepo repo;

	@Autowired
	VehicleRepo vrepo;

	@Autowired
	FeedbackRepo frepo;

	@Autowired
	VehicleDao vdao;

	@Autowired
	NotificationRepo nrepo;

	@Autowired
	NotificationDao ndao;

	@Autowired
	ResponseStructure<User>  structure;



	public ResponseEntity<ResponseStructure<User>>  saveUser(User user){
		User saveduser=dao.SaveUser(user);
		if(saveduser!=null) {
			structure.setData(saveduser);
			structure.setStatus(HttpStatus.ACCEPTED.value());
			structure.setMessage("User data stored Successfully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}


	public ResponseEntity<ResponseStructure<User>> findUserById(int id){
		User user=dao.FindByid(id);
		if(user!=null) {
			structure.setData(user);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("User data retrived Successfully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		return null;
	}


	public ResponseEntity<ResponseStructure<User>> UpdateUser(User user,int id){
		User updateduser=dao.updateUser(user, id);
		if(updateduser!=null) {
			structure.setData(updateduser);
			structure.setStatus(HttpStatus.IM_USED.value());
			structure.setMessage("User data  updated Successfully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.IM_USED);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		User user=dao.deleteUser(id);
		if(user!=null) {
			structure.setData(user);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User data deleted Successfully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		return null;
	}


	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<List<User>>(dao.findAll(),HttpStatus.FOUND);
	}


	public ResponseEntity<ResponseStructure<User>> AssignVehicleYoUser(int uid,int vid){
		User user = dao.FindByid(uid);
		Vehicle vehicle = vdao.findByid(vid);

		if (user != null) {
			if (vehicle != null) {
				if (vehicle.getUser() == null) { 
					List<Vehicle> userVehicles = user.getVehicles();
					if (userVehicles == null) {
						userVehicles = new ArrayList<>();
					}
					userVehicles.add(vehicle);
					user.setVehicles(userVehicles);


					vehicle.setUser(user);

					vrepo.save(vehicle);
					repo.save(user);

					structure.setData(user);
					structure.setMessage("User assigned to vehicle successfully");
					structure.setStatus(HttpStatus.ACCEPTED.value());
					return new ResponseEntity<>(structure, HttpStatus.ACCEPTED);
				} else {
					structure.setMessage("Vehicle is already assigned to another user");
					structure.setStatus(HttpStatus.BAD_REQUEST.value());
					return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
				}
			} else {
				structure.setMessage("Vehicle not found");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
			}
		} else {
			structure.setMessage("User not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}
	}



	public ResponseEntity<ResponseStructure<User>> AssignFeedbackToUser(int uid,int fid){
		User user=dao.FindByid(uid);
		Feedback fb=fdao.findById(fid);
		if(user!=null) {
			if(fb!=null) {

				if(fb.getUser()==null) {

					List<Feedback> userfeed=user.getFeedbacks();
					if(userfeed==null) {
						userfeed=new ArrayList();
					}
					userfeed.add(fb);
					user.setFeedbacks(userfeed);
					fb.setUser(user);

					repo.save(user);
					frepo.save(fb);

					structure.setData(user);
					structure.setMessage("assigned user to feedback Successfully");
					structure.setStatus(HttpStatus.ACCEPTED.value());
					return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);

				}
				structure.setMessage("Vehicle is already assigned to another user");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);


			}
			structure.setMessage("FeedBack not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
		}
		structure.setMessage("User not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<User>> AssignNotificationToUser(int uid,int nid){
		User user=dao.FindByid(uid);
		Notification notify=ndao.findbyId(nid);
		if (user != null) {
	        if (notify != null) {
	            if (user.getNotification() == null) {

	                user.setNotification(notify);
	                notify.setUser(user);
	                repo.save(user);  
	                nrepo.save(notify);
	                structure.setMessage("Notification assigned successfully");
	                structure.setStatus(HttpStatus.OK.value());
	                structure.setData(user);
	                return new ResponseEntity<>(structure, HttpStatus.OK);
	            } else {
	                structure.setMessage("User already has a notification assigned");
	                structure.setStatus(HttpStatus.CONFLICT.value());
	                return new ResponseEntity<>(structure, HttpStatus.CONFLICT);
	            }
	        } else {
	            structure.setMessage("Notification not found");
	            structure.setStatus(HttpStatus.NOT_FOUND.value());
	            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	        }
	    } else {
	        structure.setMessage("User not found");
	        structure.setStatus(HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	    }
	}
}
