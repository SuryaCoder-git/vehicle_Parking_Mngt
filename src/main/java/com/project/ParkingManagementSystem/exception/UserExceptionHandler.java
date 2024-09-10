package com.project.ParkingManagementSystem.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.ParkingManagementSystem.config.ResponseStructure;


@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	ResponseStructure<String> structure;
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(UserNotFoundException exception){
		structure.setData(exception.getMessage());
		structure.setMessage("User Not Found In the User Table so throw the exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserupdateException(UserDataNotUpdated exception){
		structure.setData(exception.getMessage());
		structure.setMessage("User data cannot be update so throw the exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserDeleteException(UserDataNotDeleted exception){
		structure.setData(exception.getMessage());
		structure.setMessage("User data cannot be Deleted so throw the exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserdataNotStored(UserNotSavedException exception){
		structure.setData(exception.getMessage());
		structure.setMessage("User data cannot be Stored so throw the exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserHaveNotification(UserHaveNotification exception){
		structure.setData(exception.getMessage());
		structure.setMessage("User have already notification so throw the exception");
		structure.setStatus(HttpStatus.CONFLICT.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.CONFLICT);
	}
	
	
	
	
	
	
	
	
}
