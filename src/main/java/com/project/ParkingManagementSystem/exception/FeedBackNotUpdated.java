package com.project.ParkingManagementSystem.exception;

public class FeedBackNotUpdated extends RuntimeException{

	private String message;
	
	public FeedBackNotUpdated(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
