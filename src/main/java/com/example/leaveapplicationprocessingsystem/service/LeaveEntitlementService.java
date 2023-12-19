package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveEntitlement;
import com.example.leaveapplicationprocessingsystem.repository.LeaveEntitlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveEntitlementService {

    private final LeaveEntitlementRepository leaveEntitlementRepository;

    @Autowired
    public LeaveEntitlementService(LeaveEntitlementRepository leaveEntitlementRepository) {
        this.leaveEntitlementRepository = leaveEntitlementRepository;
    }

    public LeaveEntitlement updateAnnualLeave(Integer userId, Integer annualLeave) {
        LeaveEntitlement entitlement = getEntitlement(userId);
        entitlement.setAnnualLeaveRemaining(annualLeave);
        return leaveEntitlementRepository.save(entitlement);
    }

    public LeaveEntitlement updateMedicalLeave(Integer userId, Integer medicalLeave) {
        LeaveEntitlement entitlement = getEntitlement(userId);
        entitlement.setMedicalLeaveRemaining(medicalLeave);
        return leaveEntitlementRepository.save(entitlement);
    }

    public LeaveEntitlement updateCompensationLeave(Integer userId, Integer compensationLeave) {
        LeaveEntitlement entitlement = getEntitlement(userId);
        entitlement.setCompensationLeaveRemaining(compensationLeave);
        return leaveEntitlementRepository.save(entitlement);
    }

    private LeaveEntitlement getEntitlement(Integer userId) {
        return leaveEntitlementRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
