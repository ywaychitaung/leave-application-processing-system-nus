package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.ApplicationConstants;
import com.example.leaveapplicationprocessingsystem.entity.LeaveEntitlement;
import com.example.leaveapplicationprocessingsystem.entity.User;
import com.example.leaveapplicationprocessingsystem.repository.LeaveEntitlementRepository;
import com.example.leaveapplicationprocessingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LeaveEntitlementRepository leaveEntitlementRepository;

    @Autowired
    public UserService(UserRepository userRepository, LeaveEntitlementRepository leaveEntitlementRepository) {
        this.userRepository = userRepository;
        this.leaveEntitlementRepository = leaveEntitlementRepository;
    }

    public User registerUser(User user) {
        // Add logic to handle registration (e.g., encrypting password)
        User newUser = userRepository.save(user);

        // Initialize leave entitlements
        LeaveEntitlement leaveEntitlement = new LeaveEntitlement();
        leaveEntitlement.setUserId(newUser.getUserId());
        leaveEntitlement.setMedicalLeaveRemaining(60); // 60 days for every user
        leaveEntitlement.setCompensationLeaveRemaining(0); // 0 days initially

        // Set annual leave based on role
        if (newUser.getRole() == ApplicationConstants.UserRole.MANAGERS || newUser.getRole() == ApplicationConstants.UserRole.ADMINISTRATORS) {
            leaveEntitlement.setAnnualLeaveRemaining(14); // 14 days for Managers and Admins
        } else {
            leaveEntitlement.setAnnualLeaveRemaining(18); // 18 days for Employees
        }

        leaveEntitlementRepository.save(leaveEntitlement);

        return newUser;
    }

    public User changePassword(Integer userId, String newPassword) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(newPassword); // Ensure to encrypt the password if needed
        return userRepository.save(user);
    }

    public User changeEmail(Integer userId, String newEmail) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(newEmail);
        return userRepository.save(user);
    }

    public User changeRole(Integer adminUserId, Integer userId, ApplicationConstants.UserRole newRole) {
        User adminUser = userRepository.findById(adminUserId)
                .orElseThrow(() -> new RuntimeException("Admin User not found"));

        // 检查是否为管理员
        if (adminUser.getRole() != ApplicationConstants.UserRole.ADMINISTRATORS) {
            throw new RuntimeException("Only Administrators can change user roles");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole(newRole);
        return userRepository.save(user);
    }
}
