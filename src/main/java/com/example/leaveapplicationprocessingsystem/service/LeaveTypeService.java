package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveType;

import java.util.List;

public interface LeaveTypeService {
    List<LeaveType> getAllLeaveTypes();

    LeaveType findByLeaveTypeId(Integer leaveTypeId);
}
