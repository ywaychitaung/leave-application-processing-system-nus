package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.repository.LeaveApplicationRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {
    // Create a new LeaveApplicationRepository interface object
    // 创建一个新的 LeaveApplicationRepository 接口对象
    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Override
    @Transactional
    public List<LeaveApplication> findAllByUserId(Integer userId) {
        //  Find all leave applications by user ID
        //  通过用户 ID 查找所有请假申请
        return leaveApplicationRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public LeaveApplication findByLeaveApplicationId(Integer leaveApplicationId) {
        //  Find the leave application by ID
        //  通过 ID 查找请假申请
        return leaveApplicationRepository.findByLeaveApplicationId(leaveApplicationId);
    }

    @Override
    @Transactional
    public LeaveApplication store(LeaveApplication leaveApplication, HttpSession session) {
        //  Set the leave status to "Applied"
        // 将请假状态设置为“已申请”
        leaveApplication.setLeaveStatus("Applied");

        // Set the user ID from the session
        // 从会话中设置用户 ID
        leaveApplication.setUserId((Integer) session.getAttribute("userId"));

        //  Save the leave application
        // 保存请假申请
        return leaveApplicationRepository.saveAndFlush(leaveApplication);
    }

    @Override
    @Transactional
    public LeaveApplication update(LeaveApplication leaveApplication) {
        //  Find the leave application by ID
        //  通过 ID 查找请假申请
        LeaveApplication leaveApplicationToUpdate = leaveApplicationRepository.findByLeaveApplicationId(leaveApplication.getLeaveApplicationId());

        //  Update the leave application
        //  更新请假申请
        leaveApplicationToUpdate.setLeaveTypeId(leaveApplication.getLeaveTypeId());
        leaveApplicationToUpdate.setStartDate(leaveApplication.getStartDate());
        leaveApplicationToUpdate.setEndDate(leaveApplication.getEndDate());
        leaveApplicationToUpdate.setLeaveReason(leaveApplication.getLeaveReason());

        //  Save the leave application
        //  保存请假申请
        return leaveApplicationRepository.saveAndFlush(leaveApplicationToUpdate);
    }


    @Override
    @Transactional
    public LeaveApplication cancel(Integer leaveApplicationId) {
        //  Find the leave application by ID
        //  通过 ID 查找请假申请
        LeaveApplication leaveApplication = leaveApplicationRepository.findByLeaveApplicationId(leaveApplicationId);

        //  Set the leave status to "Cancelled"
        //  将请假状态设置为“已取消”
        leaveApplication.setLeaveStatus("Cancelled");

        //  Save the leave application
        //  保存请假申请
        return leaveApplicationRepository.saveAndFlush(leaveApplication);
    }
}
