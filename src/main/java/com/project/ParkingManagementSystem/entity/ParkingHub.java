package com.project.ParkingManagementSystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "parking_hub")
public class ParkingHub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hid")
    private int hid;

    @Max(1000)
    @Column(name = "capacity")
    private int capacity;

    @NotNull
    @NotBlank
    @Column(name = "hubname")
    private String hubname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @JsonBackReference 
    private Location location;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingHub", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference 
    private List<ParkingSlot> slots;

    @OneToMany(mappedBy = "parkingHub", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getHubname() {
        return hubname;
    }

    public void setHubname(String hubname) {
        this.hubname = hubname;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
