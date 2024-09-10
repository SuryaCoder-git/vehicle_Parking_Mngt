package com.project.ParkingManagementSystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid")
    private int lid;
    
    @Min(100000)
    @Max(999999)
    @Column(name = "pincode")
    private int pincode;
    
    @NotNull
    @NotBlank
    @Column(name = "city")
    private String city;
    
    @NotNull
    @NotBlank
    @Column(name = "address")
    private String address;
    
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ParkingHub> hubs;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ParkingHub> getHubs() {
		return hubs;
	}

	public void setHubs(List<ParkingHub> hubs) {
		this.hubs = hubs;
	}

    
}
