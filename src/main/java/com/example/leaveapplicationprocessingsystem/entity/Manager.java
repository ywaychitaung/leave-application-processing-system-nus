package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="manager_id")
    private Integer managerId;

    @Column(name="user_id", insertable=false, updatable=false)
    private Integer userId;

    @Column(name="annual_leave_days_used")
    private Integer annualLeaveDaysUsed;

    @Column(name="medical_leave_days_used")
    private Integer medicalLeaveDaysUsed;

    @OneToMany(mappedBy="manager")
    private List<Employee> employees;

    public Manager() {}

    public Manager(Integer managerId,
                   Integer userId,
                   Integer annualLeaveDaysUsed,
                   Integer medicalLeaveDaysUsed) {
        this.managerId = managerId;
        this.userId = userId;
        this.annualLeaveDaysUsed = annualLeaveDaysUsed;
        this.medicalLeaveDaysUsed = medicalLeaveDaysUsed;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnnualLeaveDaysUsed() {
        return annualLeaveDaysUsed;
    }

    public void setAnnualLeaveDaysUsed(Integer annualLeaveDaysUsed) {
        this.annualLeaveDaysUsed = annualLeaveDaysUsed;
    }

    public Integer getMedicalLeaveDaysUsed() {
        return medicalLeaveDaysUsed;
    }

    public void setMedicalLeaveDaysUsed(Integer medicalLeaveDaysUsed) {
        this.medicalLeaveDaysUsed = medicalLeaveDaysUsed;
    }
}
