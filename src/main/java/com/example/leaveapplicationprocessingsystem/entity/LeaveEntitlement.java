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

    public LeaveEntitlement() {
    }

    public LeaveEntitlement(Integer userId, Integer annualLeaveRemaining, Integer medicalLeaveRemaining, Integer compensationLeaveRemaining) {
        this.userId = userId;
        this.annualLeaveRemaining = annualLeaveRemaining;
        this.medicalLeaveRemaining = medicalLeaveRemaining;
        this.compensationLeaveRemaining = compensationLeaveRemaining;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnnualLeaveRemaining() {
        return annualLeaveRemaining;
    }

    public void setAnnualLeaveRemaining(Integer annualLeaveRemaining) {
        this.annualLeaveRemaining = annualLeaveRemaining;
    }

    public Integer getMedicalLeaveRemaining() {
        return medicalLeaveRemaining;
    }

    public void setMedicalLeaveRemaining(Integer medicalLeaveRemaining) {
        this.medicalLeaveRemaining = medicalLeaveRemaining;
    }

    public Integer getCompensationLeaveRemaining() {
        return compensationLeaveRemaining;
    }

    public void setCompensationLeaveRemaining(Integer compensationLeaveRemaining) {
        this.compensationLeaveRemaining = compensationLeaveRemaining;
    }
}
