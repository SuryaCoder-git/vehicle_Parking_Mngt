package com.project.ParkingManagementSystem.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.NotificationDao;
import com.project.ParkingManagementSystem.entity.Notification;

@Service
public class NotificationService {
	
	@Autowired
	NotificationDao dao;
	
	@Autowired
	ResponseStructure<Notification>  structure;
	
	public ResponseEntity<ResponseStructure<Notification>>  saveNotification(Notification notify){
		Notification notification=dao.saveNotification(notify);
		if(notification!=null) {
			structure.setData(notification);
			structure.setMessage("notification data can be stored successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Notification>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Notification>>  findNotification(int id){
		Notification notification=dao.findbyId(id);
		if(notification!=null) {
			structure.setData(notification);
			structure.setMessage("notification data can be retrived successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Notification>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	
	public ResponseEntity<ResponseStructure<Notification>>  updatedNotification(Notification notify,int id){
		Notification notification=dao.updateNotify(notify, id);
		if(notification!=null) {
			structure.setData(notification);
			structure.setMessage("notification data can be updated successfully");
			structure.setStatus(HttpStatus.IM_USED.value());
			return new ResponseEntity<ResponseStructure<Notification>>(structure,HttpStatus.IM_USED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Notification>>  deleteNotification(int id){
		Notification notification=dao.deleteNotify(id);
		if(notification!=null) {
			structure.setData(notification);
			structure.setMessage("notification data can be  deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Notification>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	
	
	public ResponseEntity<List<Notification>> findAll(){
		return new ResponseEntity<List<Notification>>(dao.findAll(),HttpStatus.OK);
	}

}
