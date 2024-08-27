package com.project.ParkingManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ParkingManagementSystem.entity.Notification;
import com.project.ParkingManagementSystem.repo.NotificationRepo;

@Repository
public class NotificationDao {
	
	@Autowired
	NotificationRepo repo;
	
	public Notification saveNotification(Notification notify) {
		return repo.save(notify);
	}
	
	
	public Notification findbyId(int id) {
		Optional<Notification> notify=repo.findById(id);
		if(notify.isPresent()) {
			return notify.get();
		}
		return null;
	}
	
	
	public Notification updateNotify(Notification notify,int id) {
		Notification oldnotify=findbyId(id);
		if(oldnotify!=null) {
			notify.setNotificationId(id);
			return repo.save(notify);
		}
		return null;
	}
	
	
	public Notification deleteNotify(int id) {
		Notification notify=findbyId(id);
		if(notify!=null) {
			repo.delete(notify);
			return notify;
		}
		return null;
	}
	
	
	public List<Notification> findAll(){
		return repo.findAll();
	}

}
