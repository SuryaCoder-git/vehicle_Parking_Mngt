package com.project.ParkingManagementSystem.exception;

public class FeedbackNotDeleted extends RuntimeException {

	
	private String message;
	
	
	public FeedbackNotDeleted(String message) {
		this.message=message;
	}


	public String getMessage() {
		return message;
	}
	
	
	

}
