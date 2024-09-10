package com.project.ParkingManagementSystem.exception;

public class FeedbackNotFound  extends RuntimeException {

	private String message;
	
	public FeedbackNotFound(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
