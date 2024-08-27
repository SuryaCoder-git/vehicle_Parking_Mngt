package com.project.ParkingManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ParkingManagementSystem.entity.Payment;
import com.project.ParkingManagementSystem.repo.PaymentRepo;

@Repository
public class PaymentDao {

	@Autowired
	PaymentRepo repo;
	
	public Payment savepayment(Payment pay) {
		return repo.save(pay);
	}
	
	public Payment findbyId(int id) {
		Optional<Payment> pay=repo.findById(id);
		if(pay.isPresent()) {
			return pay.get();
		}
		return null;	
	}
	
	public Payment updatepayment(Payment pay,int id) {
		Payment oldpay=findbyId(id);
		if(oldpay!=null) {
			pay.setPid(id);
			return repo.save(pay);
		}
		return null;
	}
	
	public Payment deletePayment(int id)
	{
		Payment pay=findbyId(id);
	    if(pay!=null) {
	    	repo.delete(pay);
	    	return pay;
	    }	
	    return null;
	}
	
	public List<Payment> findAll(){
	 return	repo.findAll();
	}
	
}
