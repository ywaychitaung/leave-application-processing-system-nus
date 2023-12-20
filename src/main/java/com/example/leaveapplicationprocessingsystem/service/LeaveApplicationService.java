package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import jakarta.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface LeaveApplicationService {
    // Find the leave application by id
    // 通过 id 查找请假申请
    List<LeaveApplication> findAllByUserId(Integer userId);

    // Store the leave application
    // 存储请假申请
    LeaveApplication store(LeaveApplication leaveApplication, HttpSession session);

    // Find the leave application by leave application id
    // 通过请假申请 id 查找请假申请
    LeaveApplication findByLeaveApplicationId(Integer leaveApplicationId);

    // Update the leave application
    // 更新请假申请
    LeaveApplication update(LeaveApplication leaveApplication, HttpSession session);

    // Cancel the leave application
    // 取消请假申请
    LeaveApplication cancel(Integer leaveApplicationId);
}
