package com.example.leaveapplicationprocessingsystem.repository;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Integer> {
    // Method to find all leave applications by user ID
    // 通过用户ID查找所有请假申请的方法
    List<LeaveApplication> findByUserId(Integer userId);
}
