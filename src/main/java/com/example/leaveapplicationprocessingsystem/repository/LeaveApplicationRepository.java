package com.example.leaveapplicationprocessingsystem.repository;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Integer> {
    // Method to find all leave applications by user ID
    // 通过用户 ID 查找所有请假申请的方法
    List<LeaveApplication> findByUserId(Integer userId);

    // Method to find leave application by leave application ID
    // 通过请假申请 ID 查找请假申请的方法
    LeaveApplication findByLeaveApplicationId(Integer leaveApplicationId);
}
