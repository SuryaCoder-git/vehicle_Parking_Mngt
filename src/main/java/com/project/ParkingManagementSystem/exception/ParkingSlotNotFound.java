package com.project.ParkingManagementSystem.exception;

public class ParkingSlotNotFound extends RuntimeException{


	private String message;



	public ParkingSlotNotFound(String message) {
		this.message=message;
	}



	public String getMessage() {
		return message;
	}
	
	

}
