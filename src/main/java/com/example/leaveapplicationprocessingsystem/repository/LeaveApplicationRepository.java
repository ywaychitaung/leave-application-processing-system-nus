package com.example.leaveapplicationprocessingsystem.repository;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Integer> {
    // Method to find all leave applications by user ID
    // 通过用户 ID 查找所有请假申请的方法
    @Query("SELECT la FROM LeaveApplication la WHERE la.employee.userId = :userId")
    List<LeaveApplication> findByUserId(@Param("userId") Integer userId);

    // Method to fetch leave applications for employees under a specific manager
    // 通过经理 ID 查找所有下属员工的请假申请的方法
    @Query("SELECT la FROM LeaveApplication la JOIN la.employee e WHERE e.manager.managerId = :managerId")
    List<LeaveApplication> findByManagerId(@Param("managerId") Integer managerId);

    // Method to find leave application by leave application ID
    // 通过请假申请 ID 查找请假申请的方法
    LeaveApplication findByLeaveApplicationId(Integer leaveApplicationId);
}
