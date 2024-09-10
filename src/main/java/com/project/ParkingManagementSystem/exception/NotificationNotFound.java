package com.project.ParkingManagementSystem.exception;

public class NotificationNotFound extends RuntimeException{


	private String message;

	public NotificationNotFound(String message) {

		this.message=message;
	}

	public String getMessage() {
		return message;
	}



}
