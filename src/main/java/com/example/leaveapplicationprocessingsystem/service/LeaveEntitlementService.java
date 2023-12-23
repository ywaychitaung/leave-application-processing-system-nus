package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveEntitlement;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface LeaveEntitlementService {
    List<LeaveEntitlement> getAllLeaveEntitlements();

    LeaveEntitlement getLeaveEntitlementByRoleId(Integer roleId);

    LeaveEntitlement store(LeaveEntitlement leaveEntitlement);
}
