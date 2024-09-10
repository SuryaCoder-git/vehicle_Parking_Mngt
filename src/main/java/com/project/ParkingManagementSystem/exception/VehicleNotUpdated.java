package com.project.ParkingManagementSystem.exception;

public class VehicleNotUpdated extends RuntimeException {

	
	private String message;
	
	public VehicleNotUpdated(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
