package com.example.leaveapplicationprocessingsystem.repository;

import com.example.leaveapplicationprocessingsystem.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {
    // Method to find leave type by leave type ID
    // 通过请假类型 ID 查找请假类型的方法
    LeaveType findByLeaveTypeId(Integer leaveTypeId);
}
