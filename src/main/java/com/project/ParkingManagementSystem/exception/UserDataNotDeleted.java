package com.project.ParkingManagementSystem.exception;

public class UserDataNotDeleted  extends RuntimeException {

	private String message;
	
	
	public UserDataNotDeleted(String message) {
		
		
	this.message=message;
	
	}
	
	
	public String getMessage() {
		return message;
	}
	
	

}
