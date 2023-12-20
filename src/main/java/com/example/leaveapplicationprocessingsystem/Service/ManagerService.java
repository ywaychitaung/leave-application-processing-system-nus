package com.example.leaveapplicationprocessingsystem.Service;


import java.util.List;
import java.util.Map;

import com.example.leaveapplicationprocessingsystem.Entity.Employee;
import com.example.leaveapplicationprocessingsystem.Entity.application;

public interface ManagerService {
    List<application> retrieveApplicationsForManager(Long managerId);
    Map<Employee, List<application>> getLeaveApplicationsByManager(Long managerId);
    void approveApplication(Long applicationId);
    void rejectApplication(Long applicationId, String comment);
}



