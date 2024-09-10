package com.project.ParkingManagementSystem.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.ParkingManagementSystem.config.ResponseStructure;

@RestControllerAdvice
public class NotificationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	ResponseStructure<String> structure;
	
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> HandleNotificationNotFound(NotificationNotFound exception){
		structure.setData(exception.getMessage());
		structure.setMessage("Notification Not Found In database so throw the exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
