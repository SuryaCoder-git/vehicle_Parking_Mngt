package com.project.ParkingManagementSystem.exception;

public class vehicleHaveUserException  extends RuntimeException{

	
	private String message;
	
	public vehicleHaveUserException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

}
