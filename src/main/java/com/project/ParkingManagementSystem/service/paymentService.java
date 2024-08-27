package com.project.ParkingManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ParkingManagementSystem.config.ResponseStructure;
import com.project.ParkingManagementSystem.dao.PaymentDao;
import com.project.ParkingManagementSystem.entity.Payment;

@Service
public class paymentService {
	
	@Autowired
	PaymentDao dao;
	
	@Autowired
	ResponseStructure<Payment> structure;
	
	
	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment){
		Payment savedPayment=dao.savepayment(payment);
		if(savedPayment!=null) {
			structure.setData(savedPayment);
			structure.setMessage("payment data stored successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	
	public ResponseEntity<ResponseStructure<Payment>> findPayment(int id){
		Payment savedPayment=dao.findbyId(id);
		if(savedPayment!=null) {
			structure.setData(savedPayment);
			structure.setMessage("payment data Retrived successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	
	public ResponseEntity<ResponseStructure<Payment>> UpdatePayment(Payment payment,int id){
		Payment savedPayment=dao.updatepayment(payment, id);
		if(savedPayment!=null) {
			structure.setData(savedPayment);
			structure.setMessage("payment data updated successfully");
			structure.setStatus(HttpStatus.IM_USED.value());
			return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.IM_USED);
		}
		return null;
	}
	
	
	public ResponseEntity<ResponseStructure<Payment>> deletePayment(int id){
		Payment savedPayment=dao.deletePayment(id);
		if(savedPayment!=null) {
			structure.setData(savedPayment);
			structure.setMessage("payment data deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<List<Payment>>FindAll(){
		return new ResponseEntity<List<Payment>>(dao.findAll(),HttpStatus.FOUND);
	}
	
	

}
