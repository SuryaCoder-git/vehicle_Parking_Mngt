package com.project.ParkingManagementSystem.exception;

public class VehicleNotFound  extends RuntimeException{

	private String message;
	
	
	public VehicleNotFound(String message) {
		this.message=message;
	}


	public String getMessage() {
		return message;
	}
	
	

}
