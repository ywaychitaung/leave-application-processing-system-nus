package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.service.LeaveEntitlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaveEntitlement")
public class LeaveEntitlementController {

    private final LeaveEntitlementService leaveEntitlementService;

    @Autowired
    public LeaveEntitlementController(LeaveEntitlementService leaveEntitlementService) {
        this.leaveEntitlementService = leaveEntitlementService;
    }

    @PutMapping("/update/annual/{userId}")
    public void updateAnnualLeave(@PathVariable Integer userId, @RequestParam Integer annualLeave) {
        leaveEntitlementService.updateAnnualLeave(userId, annualLeave);
    }

    @PutMapping("/update/medical/{userId}")
    public void updateMedicalLeave(@PathVariable Integer userId, @RequestParam Integer medicalLeave) {
        leaveEntitlementService.updateMedicalLeave(userId, medicalLeave);
    }

    @PutMapping("/update/compensation/{userId}")
    public void updateCompensationLeave(@PathVariable Integer userId, @RequestParam Integer compensationLeave) {
        leaveEntitlementService.updateCompensationLeave(userId, compensationLeave);
    }
}
