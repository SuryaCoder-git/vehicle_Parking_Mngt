package com.project.ParkingManagementSystem.exception;

public class UserHaveNotification  extends RuntimeException {

	private String message;
	
	
	public UserHaveNotification(String message) {
		this.message=message;
	}


	public String getMessage() {
		return message;
	}
	
	

}
