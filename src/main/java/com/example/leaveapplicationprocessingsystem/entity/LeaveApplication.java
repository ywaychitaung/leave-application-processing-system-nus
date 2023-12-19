package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "leave_applications")
public class LeaveApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveApplicationId;

    private Integer userId;
    private Integer leaveTypeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveReason;
    private String leaveStatus;
    private String workDissemination;
    private String contactDetails;

    public LeaveApplication() {}

    public LeaveApplication(Integer leaveApplicationId,
                            Integer userId,
                            Integer leaveTypeId,
                            LocalDate startDate,
                            LocalDate endDate,
                            String leaveReason,
                            String leaveStatus,
                            String workDissemination,
                            String contactDetails) {
        this.leaveApplicationId = leaveApplicationId;
        this.userId = userId;
        this.leaveTypeId = leaveTypeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveReason = leaveReason;
        this.leaveStatus = leaveStatus;
        this.workDissemination = workDissemination;
        this.contactDetails = contactDetails;
    }

    public Integer getLeaveApplicationId() { return leaveApplicationId; }

    public void setLeaveApplicationId(Integer leaveApplicationId) { this.leaveApplicationId = leaveApplicationId; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getLeaveTypeId() { return leaveTypeId; }

    public void setLeaveTypeId(Integer leaveTypeId) { this.leaveTypeId = leaveTypeId; }

    public LocalDate getStartDate() { return startDate; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getLeaveReason() { return leaveReason; }

    public void setLeaveReason(String leaveReason) { this.leaveReason = leaveReason; }

    public String getLeaveStatus() { return leaveStatus; }

    public void setLeaveStatus(String leaveStatus) { this.leaveStatus = leaveStatus; }

    public String getWorkDissemination() { return workDissemination; }

    public void setWorkDissemination(String workDissemination) { this.workDissemination = workDissemination; }

    public String getContactDetails() { return contactDetails; }

    public void setContactDetails(String contactDetails) { this.contactDetails = contactDetails; }
}
