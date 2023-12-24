package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.service.LeaveApplicationService;
import com.example.leaveapplicationprocessingsystem.service.LeaveTypeService;
import com.example.leaveapplicationprocessingsystem.service.RoleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LeaveApplicationController {
    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @Autowired
    private LeaveTypeService leaveTypeService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/leave-applications")
    public String index(HttpSession session, Model model) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Type cast the user ID to Integer
        // 将用户 ID 强制转换为 Integer
        Integer userId = (Integer) session.getAttribute("userId");

        // Find all leave applications by user ID
        // 通过用户 ID 查找所有请假申请
        model.addAttribute("leaveApplications", leaveApplicationService.findAllByUserId(userId));

        // Get all leave types
        // 获取所有请假类型
        model.addAttribute("leaveTypes", leaveTypeService.getAllLeaveTypes());

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        return "leave-application/index";
    }

    @PostMapping("/leave-applications")
    public String index(@RequestParam("userId") String userId, Model model, HttpSession session) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        // Get all leave types
        // 获取所有请假类型
        model.addAttribute("leaveTypes", leaveTypeService.getAllLeaveTypes());

        Integer id = Integer.parseInt(userId);

        // Find all leave applications by user ID
        // 通过用户 ID 查找所有请假申请
        model.addAttribute("leaveApplications", leaveApplicationService.findAllByUserId(id));

        return "leave-application/index";
    }

    @GetMapping("leave-application/details/{id}")
    public String show(@PathVariable Integer id, HttpSession session, Model model) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Find the leave application by ID
        // 通过 ID 查找请假申请
        model.addAttribute("leaveApplication", leaveApplicationService.findByLeaveApplicationId(id));

        // Find the leave application by ID
        // 通过 ID 查找请假申请
        LeaveApplication leaveApplication = leaveApplicationService.findByLeaveApplicationId(id);

        // Get the leave type ID
        // 获取请假类型 ID
        Integer leaveTypeId = leaveApplication.getLeaveTypeId();

        // Get the leave type by ID
        // 通过 ID 获取请假类型
        model.addAttribute("leaveType", leaveTypeService.findByLeaveTypeId(leaveTypeId));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        return "leave-application/show";
    }

    @GetMapping("/leave-application/create")
    public String create(HttpSession session, Model model) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get all leave types
        // 获取所有请假类型
        model.addAttribute("leaveTypes", leaveTypeService.getAllLeaveTypes());

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        //  Create a new leave application
        //  创建新的请假申请
        return "leave-application/create";
    }

    @PostMapping("/leave-application/store")
    // ModelAttribute: Bind the form data to the LeaveApplication object
    // ModelAttribute：将表单数据绑定到  LeaveApplication对象
    public String store(@ModelAttribute LeaveApplication leaveApplication,
                        HttpSession session, Model model) {
        boolean isValid = leaveApplicationService.validateLeaveApplication(leaveApplication);

        if (isValid) {
            //  Store the leave application
            //  存储请假申请
            leaveApplicationService.store(leaveApplication, session);

            //  Redirect to the home page
            //  重定向到主页
            return "redirect:/leave-applications";
        } else {
            // Add an error message to the model
            model.addAttribute("errorMessage", "Leave application is invalid. Please correct the details and try again.");

            model.addAttribute("firstName", session.getAttribute("firstName"));
            model.addAttribute("lastName", session.getAttribute("lastName"));

            // Get all leave types
            // 获取所有请假类型
            model.addAttribute("leaveTypes", leaveTypeService.getAllLeaveTypes());

            // Get role name by role ID
            // 通过角色 ID 获取角色名称
            String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

            // Add the role name to the model
            // 将角色名称添加到模型中
            model.addAttribute("roleName", roleName);

            //  Redirect to the create page
            //  重定向到创建页面
            return "leave-application/create";
        }
    }

    @GetMapping("/leave-application/edit/{id}")
    public String edit(@PathVariable Integer id, HttpSession session, Model model) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get all leave types
        // 获取所有请假类型
        model.addAttribute("leaveTypes", leaveTypeService.getAllLeaveTypes());

        // Add leave application to model
        // 将请假申请添加到模型
        model.addAttribute("leaveApplication", leaveApplicationService.findByLeaveApplicationId(id));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        return "leave-application/edit";
    }

    @GetMapping("/leave-application/update")
    public String update(@ModelAttribute LeaveApplication leaveApplication, HttpSession session) {
        //  Update the leave application
        //  更新请假申请
        leaveApplicationService.update(leaveApplication, session);

        //  Redirect to the home page
        //  重定向到主页
        return "redirect:/leave-applications";
    }

    @GetMapping("/leave-application/delete/{id}")
    public String delete(@PathVariable Integer id) {
        //  Delete the leave application
        //  删除请假申请
        leaveApplicationService.delete(id);

        //  Redirect to the home page
        //  重定向到主页
        return "redirect:/leave-applications";
    }

    @GetMapping("/leave-application/cancel/{id}")
    public String cancel(@PathVariable Integer id) {
        //  Cancel the leave application
        //  取消请假申请
        leaveApplicationService.cancel(id);

        //  Redirect to the home page
        //  重定向到主页
        return "redirect:/leave-applications";
    }
}
