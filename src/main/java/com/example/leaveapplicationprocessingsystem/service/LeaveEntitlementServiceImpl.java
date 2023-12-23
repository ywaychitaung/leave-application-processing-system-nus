package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveEntitlement;
import com.example.leaveapplicationprocessingsystem.repository.LeaveEntitlementRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveEntitlementServiceImpl implements LeaveEntitlementService{
    @Autowired
    private LeaveEntitlementRepository leaveEntitlementRepository;

    @Override
    public List<LeaveEntitlement> getAllLeaveEntitlements() {
        return leaveEntitlementRepository.findAll();
    }

    @Override
    public LeaveEntitlement getLeaveEntitlementByRoleId(Integer roleId) {
        return leaveEntitlementRepository.findById(roleId).orElse(null);
    }

    @Override
    public LeaveEntitlement store(LeaveEntitlement leaveEntitlement) {
        return leaveEntitlementRepository.saveAndFlush(leaveEntitlement);
    }
}
