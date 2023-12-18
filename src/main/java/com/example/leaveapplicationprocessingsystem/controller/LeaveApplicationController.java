package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaveApplicationController {
    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @GetMapping("/leave-applications")
    public String index(Model model) {
        // Find all leave applications by user ID
        // 通过用户 ID 查找所有请假申请
        model.addAttribute("leaveApplications", leaveApplicationService.findAllByUserId(1));
        return "leave-application-list";
    }

    @GetMapping("leave-application/details/{id}")
    public String show(@PathVariable Integer id, Model model) {
        // Find the leave application by ID
        // 通过 ID 查找请假申请
        model.addAttribute("leaveApplication", leaveApplicationService.findByLeaveApplicationId(id));
        return "leave-application-show";
    }

    @RequestMapping("/leave-application/create")
    public String create() {
        //  Create a new leave application
        //  创建新的请假申请
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

    @RequestMapping("/leave-application/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        // Find the leave application by ID
        // 通过 ID 查找请假申请
        model.addAttribute("leaveApplication", leaveApplicationService.findByLeaveApplicationId(id));
        return "leave-application-edit";
    }

    @RequestMapping("/leave-application/update")
    public String update(@ModelAttribute LeaveApplication leaveApplication,
                         BindingResult bindingResult, Model model) {
        //  Validate the form data
        //  验证表单数据
        if (bindingResult.hasErrors()) { return "leave-application-edit"; }

        //  Update the leave application
        //  更新请假申请
        leaveApplicationService.update(leaveApplication);

        //  Redirect to the home page
        //  重定向到主页
        return "redirect:/";
    }

    @RequestMapping("/leave-application/cancel/{id}")
    public String cancel(@PathVariable Integer id, Model model) {
        //  Cancel the leave application
        //  取消请假申请
        leaveApplicationService.cancel(id);

        //  Redirect to the home page
        //  重定向到主页
        return "redirect:/leave-applications";
    }
}
