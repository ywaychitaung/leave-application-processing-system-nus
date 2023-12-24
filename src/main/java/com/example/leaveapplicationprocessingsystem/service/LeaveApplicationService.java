package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import jakarta.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface LeaveApplicationService {
    // Find the leave application by id
    // 通过 id 查找请假申请
    List<LeaveApplication> findAllByUserId(Integer userId);

    // Find the leave application by manager id
    // 通过经理 id 查找请假申请
    List<LeaveApplication> getLeaveApplicationsByManager(Integer managerId);

    // Group the leave applications by employee
    // 通过员工分组请假申请
    Map<Integer, List<LeaveApplication>> getLeaveApplicationsGroupedByEmployee(List<Integer> employeeIds);

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

    boolean validateLeaveApplication(LeaveApplication leaveApplication);
}
