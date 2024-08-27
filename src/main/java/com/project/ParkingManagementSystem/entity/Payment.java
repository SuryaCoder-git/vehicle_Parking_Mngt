package com.project.ParkingManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private int pid;

    @NotNull
    @Column(name = "amount")
    private double amount;

    @OneToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

    @Column(name = "exit_time", nullable = false, updatable = false)
    private LocalDateTime exitTime;

   
    public Payment() {
        this.exitTime = LocalDateTime.now();
    }

   

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

}
