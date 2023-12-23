package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApproval;
import com.example.leaveapplicationprocessingsystem.repository.LeaveApprovalRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveApprovalServiceImpl implements LeaveApprovalService {
    @Autowired
    private LeaveApprovalRepository leaveApprovalRepository;

    public LeaveApproval approveLeave(LeaveApproval leaveApproval, HttpSession session) {
        leaveApproval.setLeaveStatus("Approved");

        //  Save the leave application
        // 保存请假申请
        return leaveApprovalRepository.saveAndFlush(leaveApproval);
    }
}
