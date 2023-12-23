package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.Manager;
import com.example.leaveapplicationprocessingsystem.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager getManagerById(Integer managerId) {
        return managerRepository.findByManagerId(managerId);
    }

    @Override
    public Manager getManagerByUserId(Integer userId) {
        return managerRepository.findByUserId(userId);
    }
}
