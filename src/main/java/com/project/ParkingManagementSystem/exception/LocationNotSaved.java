package com.project.ParkingManagementSystem.exception;

public class LocationNotSaved  extends RuntimeException {

	private String message;
	
	public LocationNotSaved(String message) {
	  
		this.message=message;
		
	}

	public String getMessage() {
		return message;
	}
	
	

}
