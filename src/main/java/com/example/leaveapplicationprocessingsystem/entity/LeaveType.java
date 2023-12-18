package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_types")
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveTypeId;

    private String leaveTypeName;

    public LeaveType() {}

    public LeaveType(Integer leaveTypeId,
                     String leaveTypeName) {
        this.leaveTypeId = leaveTypeId;
        this.leaveTypeName = leaveTypeName;
    }

    public Integer getLeaveTypeId() { return leaveTypeId; }

    public void setLeaveTypeId(Integer leaveTypeId) { this.leaveTypeId = leaveTypeId; }

    public String getLeaveTypeName() { return leaveTypeName; }

    public void setLeaveTypeName(String leaveTypeName) { this.leaveTypeName = leaveTypeName; }
}
