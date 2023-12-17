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
}
