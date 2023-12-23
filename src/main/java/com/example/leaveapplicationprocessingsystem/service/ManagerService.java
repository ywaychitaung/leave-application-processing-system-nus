package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.Manager;

public interface ManagerService {
    Manager getManagerById(Integer managerId);

    Manager getManagerByUserId(Integer userId);
}
