package com.project.ParkingManagementSystem.exception;

public class VehicleNotDeleted  extends RuntimeException{

	private String message;
	
	public VehicleNotDeleted(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	
}
