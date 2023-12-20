package com.example.leaveapplicationprocessingsystem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.leaveapplicationprocessingsystem.Entity.Employee;
import com.example.leaveapplicationprocessingsystem.Entity.application;
import com.example.leaveapplicationprocessingsystem.Service.ManagerService;

import org.springframework.ui.Model;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) 
    {
        this.managerService = managerService;
    }

    @GetMapping("/applications")
    public ResponseEntity<List<application>> viewApplications(@RequestParam Long managerId) 
    {
        List<application> applications = managerService.retrieveApplicationsForManager(managerId);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/view-leave-applications")
    public String viewLeaveApplications(Model model, @RequestParam("managerId") Long managerId) 
    {
    Map<Employee, List<application>> applications = managerService.getLeaveApplicationsByManager(managerId);
    model.addAttribute("applications", applications);
    return "leave-applications"; 
    }

    @GetMapping("/leave-application-details/{applicationId}")
    public String viewLeaveApplicationDetails(Model model, @PathVariable Long applicationId)
    {
    application application =  applicationService.getApplicationById(applicationId);
    model.addAttribute("application", application);
    return "leave-application-details"; 
    }

    @PostMapping("/applications/approve")
    public String approveApplication(@RequestParam("applicationId") Long applicationId) 
    {
    managerService.approveApplication(applicationId);
    return "redirect:/manager/applications"; 
    }   

    @PostMapping("/applications/reject")
    public String rejectApplication(@RequestParam("applicationId") Long applicationId,
                                @RequestParam("comment") String comment) 
                                {
    managerService.rejectApplication(applicationId, comment);
    return "redirect:/manager/applications"; 
    }


}
