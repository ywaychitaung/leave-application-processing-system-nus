package com.example.leaveapplicationprocessingsystem.repository;

import com.example.leaveapplicationprocessingsystem.entity.LeaveEntitlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveEntitlementRepository extends JpaRepository<LeaveEntitlement, Integer> {
    // You can add custom query methods here if needed
}
