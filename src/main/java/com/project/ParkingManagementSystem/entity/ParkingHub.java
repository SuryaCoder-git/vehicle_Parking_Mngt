package com.project.ParkingManagementSystem.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Location location;
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingHub")
    @JsonIgnore
    private Set<ParkingSlot> slots;

    
    @OneToMany(mappedBy = "parkingHub", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    // Getters and Setters
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

    public Set<ParkingSlot> getSlots() {
        return slots;
    }

    public void setSlots(Set<ParkingSlot> slots) {
        this.slots = slots;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
