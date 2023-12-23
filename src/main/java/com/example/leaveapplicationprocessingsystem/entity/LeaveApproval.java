package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_approvals")
public class LeaveApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="approval_id")
    private Integer approvalId;

    @Column(name="leave_application_id", insertable=false, updatable=false)
    private Integer leaveApplicationId;

    @Column(name="leave_status")
    private String leaveStatus;

    @Column(name="comment")
    private String comment;

    public LeaveApproval() {}

    public LeaveApproval(Integer approvalId,
                         Integer leaveApplicationId,
                         String leaveStatus,
                         String comment) {
        this.approvalId = approvalId;
        this.leaveApplicationId = leaveApplicationId;
        this.leaveStatus = leaveStatus;
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

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
