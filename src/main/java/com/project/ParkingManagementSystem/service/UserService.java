package com.project.ParkingManagementSystem.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.*;
import com.project.ParkingManagementSystem.entity.*;
import com.project.ParkingManagementSystem.exception.*;
import com.project.ParkingManagementSystem.repo.*;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	@Autowired
	FeedbackDao fdao;

	@Autowired
	VehicleDao vdao;

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
		throw new UserNotSavedException("User data cannot be Stored");
	}


	public ResponseEntity<ResponseStructure<User>> findUserById(int id){
		User user=dao.FindByid(id);
		if(user!=null) {
			structure.setData(user);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("User data retrived Successfully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		throw new UserNotFoundException("User not found this given id");
	}


	public ResponseEntity<ResponseStructure<User>> UpdateUser(User user,int id){
		User updateduser=dao.updateUser(user, id);
		if(updateduser!=null) {
			structure.setData(updateduser);
			structure.setStatus(HttpStatus.IM_USED.value());
			structure.setMessage("User data  updated Successfully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.IM_USED);
		}
		throw new UserDataNotUpdated("User data not updated");
	}



	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		User user=dao.deleteUser(id);
		if(user!=null) {
			structure.setData(user);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User data deleted Successfully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new UserDataNotDeleted("User data not Deleted");
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
					vdao.saveVehicle(vehicle);
					dao.SaveUser(user);
					structure.setData(user);
					structure.setMessage("User assigned to vehicle successfully");
					structure.setStatus(HttpStatus.ACCEPTED.value());
					return new ResponseEntity<>(structure, HttpStatus.ACCEPTED);
				} else {
					throw new vehicleHaveUserException("Vehicle already have User");
				}
			} else {
				throw new VehicleNotFound("vehicle not Found");
			}
		} else {
			throw new UserNotFoundException("User not found this given id");
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
					dao.SaveUser(user);
					fdao.savefeed(fb);
					structure.setData(user);
					structure.setMessage("assigned user to feedback Successfully");
					structure.setStatus(HttpStatus.ACCEPTED.value());
					return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
				}
				throw new vehicleHaveUserException("vehicle already have a User");
			}
			throw new FeedbackNotFound("Feedback Not Found Exception");
		}
		throw new UserNotFoundException("User Not Found Exception");
	}

	public ResponseEntity<ResponseStructure<User>> AssignNotificationToUser(int uid,int nid){
		User user=dao.FindByid(uid);
		Notification notify=ndao.findbyId(nid);
		if (user != null) {
			if (notify != null) {
				if (user.getNotification() == null) {

					user.setNotification(notify);
					notify.setUser(user);
					dao.SaveUser(user);
					ndao.saveNotification(notify);
					structure.setMessage("Notification assigned successfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(user);
					return new ResponseEntity<>(structure, HttpStatus.OK);
				} else {
					throw new UserHaveNotification("User Already Have a notification");
				}
			} else {
				throw new NotificationNotFound("Notification not Found this Id");
			}
		} else {
			throw new UserNotFoundException("User not found this given id");
		}
	}
}
