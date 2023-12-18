package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave_approvals")
public class LeaveApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer approvalId;

    private Integer leaveApplicationId;

    private String status;

    private String comment;

    public LeaveApproval() {}

    public LeaveApproval(Integer approvalId,
                         Integer leaveApplicationId,
                         String status,
                         String comment) {
        this.approvalId = approvalId;
        this.leaveApplicationId = leaveApplicationId;
        this.status = status;
        this.comment = comment;
    }

    public Integer getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public Integer getLeaveApplicationId() {
        return leaveApplicationId;
    }

    public void setLeaveApplicationId(Integer leaveApplicationId) {
        this.leaveApplicationId = leaveApplicationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
