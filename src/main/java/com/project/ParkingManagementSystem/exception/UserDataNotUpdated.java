package com.project.ParkingManagementSystem.exception;

public class UserDataNotUpdated  extends RuntimeException{

	private String message;
	public UserDataNotUpdated(String message) {
		this.message=message;

	}
	public String getMessage() {
		return message;
	}
}
