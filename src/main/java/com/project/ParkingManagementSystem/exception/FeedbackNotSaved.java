package com.project.ParkingManagementSystem.exception;

public class FeedbackNotSaved  extends RuntimeException {

	
	private String message;
	
	public FeedbackNotSaved(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
