package com.project.ParkingManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vid")
    private int vid;

    @Min(1)
    @Max(9999)
    @Column(name = "vnum")
    private int vnum;
    
    @NotNull
    @NotBlank
    @Column(name = "vbrand")
    private String vbrand;
    
    @NotNull
    @NotBlank
    @Column(name = "vcolor")
    private String vcolor;
    
    @NotNull
    @NotBlank
    @Column(name = "vtype")
    private String vtype;
    
    @ManyToOne
    @JoinColumn(name = "user_uid", referencedColumnName = "uid")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "slot_sid")
    private ParkingSlot parkingSlot;

    
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int getVnum() {
		return vnum;
	}

	public void setVnum(int vnum) {
		this.vnum = vnum;
	}

	public String getVbrand() {
		return vbrand;
	}

	public void setVbrand(String vbrand) {
		this.vbrand = vbrand;
	}

	public String getVcolor() {
		return vcolor;
	}

	public void setVcolor(String vcolor) {
		this.vcolor = vcolor;
	}

	public String getVtype() {
		return vtype;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
   
}
