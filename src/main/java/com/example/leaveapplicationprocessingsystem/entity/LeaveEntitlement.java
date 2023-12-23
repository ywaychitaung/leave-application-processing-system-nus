package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_entitlements")
public class LeaveEntitlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_entitlement_id")
    private Integer leaveEntitlementId;

    @Column(name="role_id", insertable=false, updatable=false)
    private Integer roleId;  // Assuming this is a foreign key referencing the User table

    @Column(name = "annual_leave")
    private Integer annualLeave;

    @Column(name = "medical_leave")
    private Integer medicalLeave;

    @Column(name = "compensation_leave")
    private Integer compensationLeave;

    public LeaveEntitlement() {}

    public LeaveEntitlement(Integer leaveEntitlementId,Integer roleId, Integer annualLeaveRemaining, Integer medicalLeaveRemaining, Integer compensationLeaveRemaining) {
        this.leaveEntitlementId = leaveEntitlementId;
        this.roleId = roleId;
        this.annualLeave = annualLeaveRemaining;
        this.medicalLeave = medicalLeaveRemaining;
        this.compensationLeave = compensationLeaveRemaining;
    }

    public Integer getLeaveEntitlementId() {
        return leaveEntitlementId;
    }

    public void setLeaveEntitlementId(Integer leaveEntitlementId) {
        this.leaveEntitlementId = leaveEntitlementId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(Integer annualLeaveRemaining) {
        this.annualLeave = annualLeaveRemaining;
    }

    public Integer getMedicalLeave() {
        return medicalLeave;
    }

    public void setMedicalLeave(Integer medicalLeaveRemaining) {
        this.medicalLeave = medicalLeaveRemaining;
    }

    public Integer getCompensationLeave() {
        return compensationLeave;
    }

    public void setCompensationLeave(Integer compensationLeaveRemaining) {
        this.compensationLeave = compensationLeaveRemaining;
    }
}