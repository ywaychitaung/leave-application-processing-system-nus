package com.example.leaveapplicationprocessingsystem.Data;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.repository.LeaveApplicationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class LeaveApplicationData {
    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Test
    public void createLeaveApplicationData() {
        LeaveApplication leaveApp1 = new LeaveApplication();
        leaveApp1.setUserId(1); // Assuming this is a valid user ID
        leaveApp1.setLeaveTypeId(1); // Assuming this is a valid leave type ID
        leaveApp1.setStartDate(LocalDate.of(2023, 1, 1));
        leaveApp1.setEndDate(LocalDate.of(2023, 1, 10));
        leaveApp1.setLeaveReason("Annual Leave");
        leaveApp1.setLeaveStatus("Applied");

        leaveApplicationRepository.save(leaveApp1);
    }
}
