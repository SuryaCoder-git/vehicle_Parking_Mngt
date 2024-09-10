package com.project.ParkingManagementSystem.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.ParkingManagementSystem.config.ResponseStructure;

@RestControllerAdvice
public class VehicleExceptionHandler  extends ResponseEntityExceptionHandler{

	@Autowired
	ResponseStructure<String> structure;

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> HandleVehicleNotSaved(VehicleNotSaved exception){
		structure.setMessage("Vechile data cannot be Stored in database");
		structure.setData(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> HandleVehicleNotUpdated(VehicleNotUpdated exception){
		structure.setMessage("Vechile data cannot be Updated in database");
		structure.setData(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> HandleVehicleNotFound(VehicleNotFound exception){
		structure.setMessage("Vechile data cannot be Found in database");
		structure.setData(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> HandleVehicleNotDeleted(VehicleNotDeleted exception){
		structure.setMessage("Vechile data cannot be Found in database");
		structure.setData(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> HandleVehicleHaveUser(vehicleHaveUserException exception){
		structure.setMessage("Vechile already have a User so throw exception");
		structure.setData(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> HandleVehicleHaveSlot(VehicleHaveSlot exception){
		structure.setMessage("Vechile already have a Slot so throw exception");
		structure.setData(exception.getMessage());
		structure.setStatus(HttpStatus.CONFLICT.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.CONFLICT);
	}

}
