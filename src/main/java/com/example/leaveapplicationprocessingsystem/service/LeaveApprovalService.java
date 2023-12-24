package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApproval;
import jakarta.servlet.http.HttpSession;

public interface LeaveApprovalService {
    LeaveApproval approveLeave(LeaveApproval leaveApproval, HttpSession session);

    LeaveApproval rejectLeave(LeaveApproval leaveApproval, HttpSession session);
}
