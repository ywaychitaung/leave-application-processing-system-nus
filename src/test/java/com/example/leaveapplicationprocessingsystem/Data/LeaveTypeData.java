package com.example.leaveapplicationprocessingsystem.Data;

import com.example.leaveapplicationprocessingsystem.entity.LeaveType;
import com.example.leaveapplicationprocessingsystem.repository.LeaveTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LeaveTypeData {
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Test
    public void createLeaveTypeData() {
        LeaveType annualLeave = new LeaveType();
        annualLeave.setLeaveTypeName("Annual");

        LeaveType medicalLeave = new LeaveType();
        medicalLeave.setLeaveTypeName("Medical");

        LeaveType compensationLeave = new LeaveType();
        compensationLeave.setLeaveTypeName("Compensation");

        // Save the leave types
        leaveTypeRepository.save(annualLeave);
        leaveTypeRepository.save(medicalLeave);
        leaveTypeRepository.save(compensationLeave);
    }
}
