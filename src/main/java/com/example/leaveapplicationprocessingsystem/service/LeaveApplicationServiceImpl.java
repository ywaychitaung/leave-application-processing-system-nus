package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.repository.LeaveApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {
    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Override
    @Transactional
    public LeaveApplication store(LeaveApplication leaveApplication) {
        //  Set the leave status to "Applied"
        // 将请假状态设置为“已申请”
        leaveApplication.setLeaveStatus("Applied");

        // Set the user id to 1 (for testing purpose)
        // 将用户ID设置为1（用于测试目的）
        leaveApplication.setUserId(1);

        //  Save the leave application
        // 保存请假申请
        return leaveApplicationRepository.saveAndFlush(leaveApplication);
    }
}
