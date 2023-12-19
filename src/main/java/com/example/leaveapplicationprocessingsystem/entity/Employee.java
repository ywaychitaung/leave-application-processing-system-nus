package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private Integer userId;

    private Integer annualLeaveDaysUsed;

    private Integer medicalLeaveDaysUsed;

    public Employee() {}

    public Employee(Integer employeeId,
                    Integer userId,
                    Integer annualLeaveDaysUsed,
                    Integer medicalLeaveDaysUsed) {
        this.employeeId = employeeId;
        this.userId = userId;
        this.annualLeaveDaysUsed = annualLeaveDaysUsed;
        this.medicalLeaveDaysUsed = medicalLeaveDaysUsed;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
