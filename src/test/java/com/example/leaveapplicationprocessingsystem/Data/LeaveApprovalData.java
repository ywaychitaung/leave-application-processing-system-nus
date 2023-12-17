package com.example.leaveapplicationprocessingsystem.Data;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApproval;
import com.example.leaveapplicationprocessingsystem.repository.LeaveApprovalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LeaveApprovalData {
    @Autowired
    private LeaveApprovalRepository leaveApprovalRepository;

    @Test
    public void createLeaveApprovalData() {
        LeaveApproval approval1 = new LeaveApproval(1, 1, "Approved", "Good");

        leaveApprovalRepository.save(approval1);
    }
}
