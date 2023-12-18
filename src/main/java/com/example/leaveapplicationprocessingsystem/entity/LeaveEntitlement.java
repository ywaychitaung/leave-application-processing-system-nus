package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_entitlement")
public class LeaveEntitlement {
    @Id
    private Integer userId;  // Assuming this is a foreign key referencing the User table

    @Column(name = "annual_leave_remaining")
    private Integer annualLeaveRemaining;

    @Column(name = "medical_leave_remaining")
    private Integer medicalLeaveRemaining;

    @Column(name = "compensation_leave_remaining")
    private Integer compensationLeaveRemaining;

    // Default constructor
    public LeaveEntitlement() {
    }

    // Constructor with fields
    public LeaveEntitlement(Integer userId, Integer annualLeaveRemaining, Integer medicalLeaveRemaining, Integer compensationLeaveRemaining) {
        this.userId = userId;
        this.annualLeaveRemaining = annualLeaveRemaining;
        this.medicalLeaveRemaining = medicalLeaveRemaining;
        this.compensationLeaveRemaining = compensationLeaveRemaining;
    }

    // Getters and Setters
    // ...

    // Other methods if needed
    // ...
}

