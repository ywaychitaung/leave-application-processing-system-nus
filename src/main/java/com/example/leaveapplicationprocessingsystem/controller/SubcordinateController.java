package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.Employee;
import com.example.leaveapplicationprocessingsystem.entity.Manager;
import com.example.leaveapplicationprocessingsystem.entity.User;
import com.example.leaveapplicationprocessingsystem.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubcordinateController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping("/subcordinates")
    public String index(Model model, HttpSession session) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();
        model.addAttribute("roleName", roleName);

        Manager manager = managerService.getManagerByUserId((Integer) session.getAttribute("userId"));

        List<Employee> employees = employeeService.getEmployeesByManager(manager.getManagerId());

        List<User> users = new ArrayList<>();

        for (Employee employee : employees) {
            User user = userService.findByUserId(employee.getUserId());
            users.add(user);
        }

        model.addAttribute("users", users);

        return "subcordinate/index";
    }
}
