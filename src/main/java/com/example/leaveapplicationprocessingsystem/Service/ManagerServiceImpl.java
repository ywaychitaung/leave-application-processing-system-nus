package com.example.leaveapplicationprocessingsystem.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.stereotype.Service;

import com.example.leaveapplicationprocessingsystem.Entity.Employee;
import com.example.leaveapplicationprocessingsystem.Entity.application;
import com.example.leaveapplicationprocessingsystem.Repsoitory.ApplicationRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

     private final ApplicationRepository applicationRepository;
    
     @Autowired
     public ManagerServiceImpl(ApplicationRepository applicationRepository) 
     {
         this.applicationRepository = applicationRepository;
     }
 

    @Override
    public List<application> retrieveApplicationsForManager(Long managerId) 
    {
        return applicationRepository.findByManagerId(managerId);
    }

    @Override
    public Map<Employee, List<application>> getLeaveApplicationsByManager(Long managerId) 
    {
        List<application> applications = retrieveApplicationsForManager(managerId);
        return applications.stream().collect(Collectors.groupingBy(application::getEmployee));
    }

    @Override
    public void approveApplication(Long applicationId) 
    {
    application application = applicationRepository.findById(applicationId)
        .orElseThrow(() -> new RuntimeException("Application not found"));
    application.setStatus("Approved");
    applicationRepository.save(application);
    }


    @Override
    public void rejectApplication(Long applicationId, String comment)
    {
    application application = applicationRepository.findById(applicationId)
        .orElseThrow(() -> new RuntimeException("Application not found"));
    application.setStatus("Rejected");
    application.setManagerComment(comment);
    applicationRepository.save(application); 
    }
}

