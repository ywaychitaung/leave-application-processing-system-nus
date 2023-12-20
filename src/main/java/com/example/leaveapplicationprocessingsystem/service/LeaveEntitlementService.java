package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveEntitlement;
import com.example.leaveapplicationprocessingsystem.repository.LeaveEntitlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface LeaveEntitlementService {
    LeaveEntitlement updateAnnualLeave(Integer userId, Integer annualLeave);

    LeaveEntitlement updateMedicalLeave(Integer userId, Integer medicalLeave);

    LeaveEntitlement updateCompensationLeave(Integer userId, Integer compensationLeave);

    LeaveEntitlement getEntitlement(Integer userId);
}
