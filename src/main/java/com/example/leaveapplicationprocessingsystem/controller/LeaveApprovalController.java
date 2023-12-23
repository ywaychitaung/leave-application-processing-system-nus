package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.Employee;
import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.entity.LeaveApproval;
import com.example.leaveapplicationprocessingsystem.entity.Manager;
import com.example.leaveapplicationprocessingsystem.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class LeaveApprovalController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private LeaveTypeService leaveTypeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @Autowired
    private LeaveApprovalService leaveApprovalService;

    @GetMapping("/leave-approvals")
    public String index(Model model, HttpSession session) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        Manager manager = managerService.getManagerByUserId((Integer) session.getAttribute("userId"));

        List<Employee> employees = employeeService.getEmployeesByManager(manager.getManagerId());

        Map<Integer, List<LeaveApplication>> leaveApplicationsByEmployee = leaveApplicationService.getLeaveApplicationsGroupedByEmployee(
                employees.stream().map(Employee::getUserId).collect(Collectors.toList())
        );

        model.addAttribute("employees", employees);
        model.addAttribute("leaveApplicationsByEmployee", leaveApplicationsByEmployee);

        return "leave-approval/index";
    }

    @GetMapping("leave-application/approvals/{id}")
    public String show(@PathVariable Integer id, Model model, HttpSession session) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        // Find the leave application by ID
        // 通过 ID 查找请假申请
        LeaveApplication leaveApplication = leaveApplicationService.findByLeaveApplicationId(id);

        // Get the leave type ID
        // 获取请假类型 ID
        Integer leaveTypeId = leaveApplication.getLeaveTypeId();

        // Get the leave type by ID
        // 通过 ID 获取请假类型
        model.addAttribute("leaveType", leaveTypeService.findByLeaveTypeId(leaveTypeId));

        model.addAttribute("leaveApplication", leaveApplication);

        return "leave-approval/show";
    }

    @PostMapping("/leave-application/approve/{id}")
    public String approveLeave(LeaveApproval leaveApproval, HttpSession session) {
        // Update the leave application
        // 更新请假申请
        leaveApprovalService.approveLeave(leaveApproval, session);

        return "redirect:/leave-approvals";
    }
}
