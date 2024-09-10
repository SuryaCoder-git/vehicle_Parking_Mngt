package com.project.ParkingManagementSystem.exception;

public class UserNotSavedException extends RuntimeException{

	private String message;
	
	public UserNotSavedException(String message) {
	this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
