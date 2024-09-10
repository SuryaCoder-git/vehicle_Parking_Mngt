package com.project.ParkingManagementSystem.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.ParkingManagementSystem.config.ResponseStructure;

public class FeedbackExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	ResponseStructure<String> structure;
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleFeedbackNotFoundException(FeedbackNotFound exception){
		structure.setData(exception.getMessage());
		structure.setMessage("feedback Not Found In the Feedback Table so throw the exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleFeedbackNotUpdatedException(FeedBackNotUpdated exception){
		structure.setData(exception.getMessage());
		structure.setMessage("feedback Not Updated In the Feedback Table so throw the exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleFeedbackNotDeletedException(FeedbackNotDeleted exception){
		structure.setData(exception.getMessage());
		structure.setMessage("feedback Not Deleted In the Feedback Table so throw the exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleFeedbackNotSavedException(FeedbackNotSaved exception){
		structure.setData(exception.getMessage());
		structure.setMessage("feedback Not Saved In the Feedback Table so throw the exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
}
