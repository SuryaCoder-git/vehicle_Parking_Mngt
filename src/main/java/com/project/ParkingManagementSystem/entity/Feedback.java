package com.project.ParkingManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "feedback")
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fid")
    private int fid;
    
    @NotBlank
    @NotNull
    @Column(name = "message")
    private String message;
    
    @Min(0)
    @Max(5)
    @Column(name = "ratings")
    private int ratings;
    
    @ManyToOne
    @JoinColumn(name = "user_uid")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "parkinghub_id")
    @JsonBackReference
    private ParkingHub parkingHub;


    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParkingHub getParkingHub() {
        return parkingHub;
    }

    public void setParkingHub(ParkingHub parkingHub) {
        this.parkingHub = parkingHub;
    }
}
