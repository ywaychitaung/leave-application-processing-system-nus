package com.example.leaveapplicationprocessingsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leaveapplicationprocessingsystem.Entity.application;
import com.example.leaveapplicationprocessingsystem.Repsoitory.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Application not found"));
    }
}
