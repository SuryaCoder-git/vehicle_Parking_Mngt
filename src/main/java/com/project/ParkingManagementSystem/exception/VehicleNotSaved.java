package com.project.ParkingManagementSystem.exception;

public class VehicleNotSaved  extends RuntimeException {

	private String message;
	
	public VehicleNotSaved(String message) {
	this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
