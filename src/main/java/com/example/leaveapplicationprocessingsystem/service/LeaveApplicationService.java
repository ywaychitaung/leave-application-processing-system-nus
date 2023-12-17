package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public interface LeaveApplicationService {
    // Store the leave application
    // 存储请假申请
    LeaveApplication store(LeaveApplication leaveApplication);
}
