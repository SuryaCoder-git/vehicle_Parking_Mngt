package com.project.ParkingManagementSystem.exception;

public class VehicleHaveSlot  extends RuntimeException {

	private String message;
	
	
	public VehicleHaveSlot(String message) {
		this.message=message;
	}


	public String getMessage() {
		return message;
	}
	
	

}
