package com.example.leaveapplicationprocessingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/leave-entitlement")
public class LeaveEntitlementController {

    private final LeaveEntitlementService leaveEntitlementService;

    @Autowired
    public LeaveEntitlementController(LeaveEntitlementService leaveEntitlementService) {
        this.leaveEntitlementService = leaveEntitlementService;
    }

    @GetMapping
    public ResponseEntity<List<LeaveEntitlement>> getAllEntitlements() {
        return ResponseEntity.ok(leaveEntitlementService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveEntitlement> updateEntitlement(@PathVariable Long id, @RequestBody LeaveEntitlement entitlement, @PathVariable String id) {
        return ResponseEntity.ok(leaveEntitlementService.updateEntitlement(id, entitlement));
    }

    // Additional endpoints as needed
}

