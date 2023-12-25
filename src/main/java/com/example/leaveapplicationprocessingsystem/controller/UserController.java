package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.entity.User;
import com.example.leaveapplicationprocessingsystem.service.RoleService;
import com.example.leaveapplicationprocessingsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String index(HttpSession session, Model model) {
        model.addAttribute("admins", userService.findByRoleId(1));
        model.addAttribute("employees", userService.findByRoleId(2));
        model.addAttribute("managers", userService.findByRoleId(3));

        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        return "user/index";
    }

    @GetMapping("/user/show/{id}")
    public String show(@PathVariable Integer id, HttpSession session, Model model) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        String userRoleName = roleService.getRoleNameByRoleId(userService.findByUserId(id).getRoleId()).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        model.addAttribute("userRoleName", userRoleName);

        model.addAttribute("user", userService.findByUserId(id));

        return "user/show";
    }

    @GetMapping("/user/create")
    public String create(HttpSession session, Model model) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        model.addAttribute("roles", roleService.getAllRoles());

        return "user/create";
    }

    @PostMapping("/user/store")
    // ModelAttribute: Bind the form data to the LeaveApplication object
    // ModelAttribute：将表单数据绑定到  LeaveApplication对象
    public String store(@ModelAttribute User user,
                        HttpSession session) {
        //  Save the leave application
        //  保存请假申请
        userService.store(user, session);

        //  Redirect to the home page
        //  重定向到主页
        return "redirect:/users";
    }

    @GetMapping("/user/edit/{id}")
    public String edit(@PathVariable Integer id, HttpSession session, Model model) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        String userRoleName = roleService.getRoleNameByRoleId(userService.findByUserId(id).getRoleId()).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        // Get all roles
        // 获取所有角色
        model.addAttribute("roles", roleService.getAllRoles());

        model.addAttribute("userRoleName", userRoleName);

        model.addAttribute("roles", roleService.getAllRoles());

        model.addAttribute("user", userService.findByUserId(id));

        return "user/edit";
    }

    @PostMapping("/user/update")
    public String update(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
