package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaveApplicationController {
    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @GetMapping("/leave-applications")
    public String index(Model model) {
        model.addAttribute("leaveApplications", leaveApplicationService.findAllByUserId(1));
        return "leave-application-list";
    }

    @RequestMapping("/leave-application/create")
    public String create() {
        return "leave-application";
    }

    @RequestMapping("/leave-application/store")
    // ModelAttribute: Bind the form data to the LeaveApplication object
    // ModelAttribute：将表单数据绑定到  LeaveApplication对象
    public String store(@ModelAttribute LeaveApplication leaveApplication,
                        BindingResult bindingResult, Model model) {

        //  Validate the form data
        //  验证表单数据
        if (bindingResult.hasErrors()) { return "leave-application"; }

        //  Save the leave application
        //  保存请假申请
        leaveApplicationService.store(leaveApplication);

        //  Redirect to the home page
        //  重定向到主页
        return "redirect:/";
    }
}
