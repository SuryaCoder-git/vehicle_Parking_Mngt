package com.project.ParkingManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_slot")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private int slotId;

    @ManyToOne
    @JoinColumn(name = "hub_id", nullable = true)
    private ParkingHub parkingHub;

    @OneToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

    @Column(name = "slot_number", nullable = false)
    private String slotNumber;

    @Column(name = "is_occupied")
    private boolean isOccupied;

    @Column(name = "entry_time")
    private LocalDateTime entryTime;

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public ParkingHub getParkingHub() {
        return parkingHub;
    }

    public void setParkingHub(ParkingHub parkingHub) {
        this.parkingHub = parkingHub;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    @JsonProperty("isOccupied")
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
        if (!isOccupied) {
            this.entryTime = LocalDateTime.now();
        } else {
            this.entryTime = null;
        }
    }

    @JsonProperty("isOccupied")
    public boolean isOccupied() {
        return this.isOccupied;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        if (!this.isOccupied) {
            this.entryTime = entryTime;
        }
    }
}
