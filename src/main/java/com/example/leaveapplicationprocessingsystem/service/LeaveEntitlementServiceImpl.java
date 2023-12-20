package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveEntitlement;
import com.example.leaveapplicationprocessingsystem.repository.LeaveEntitlementRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaveEntitlementServiceImpl implements LeaveEntitlementService {
    private final LeaveEntitlementRepository leaveEntitlementRepository;

    public LeaveEntitlementServiceImpl(LeaveEntitlementRepository leaveEntitlementRepository) {
        this.leaveEntitlementRepository = leaveEntitlementRepository;
    }

    // Create the entitlement of a user
    public LeaveEntitlement updateAnnualLeave(Integer userId, Integer annualLeave) {
        LeaveEntitlement entitlement = getEntitlement(userId);
        entitlement.setAnnualLeaveRemaining(annualLeave);
        return leaveEntitlementRepository.save(entitlement);
    }

    // Update the medical leave of a user
    public LeaveEntitlement updateMedicalLeave(Integer userId, Integer medicalLeave) {
        LeaveEntitlement entitlement = getEntitlement(userId);
        entitlement.setMedicalLeaveRemaining(medicalLeave);
        return leaveEntitlementRepository.save(entitlement);
    }

    // Update the compensation leave of a user
    public LeaveEntitlement updateCompensationLeave(Integer userId, Integer compensationLeave) {
        LeaveEntitlement entitlement = getEntitlement(userId);
        entitlement.setCompensationLeaveRemaining(compensationLeave);
        return leaveEntitlementRepository.save(entitlement);
    }

    // Get the entitlement of a user
    public LeaveEntitlement getEntitlement(Integer userId) {
        return leaveEntitlementRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
