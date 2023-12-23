package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.PublicHoliday;
import com.example.leaveapplicationprocessingsystem.entity.User;
import com.example.leaveapplicationprocessingsystem.service.PublicHolidayService;
import com.example.leaveapplicationprocessingsystem.service.RoleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class PublicHolidayController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PublicHolidayService publicHolidayService;

    @GetMapping("/holiday/create")
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

        LocalDate now = LocalDate.now();
        String startOfYear = now.withDayOfYear(1).format(DateTimeFormatter.ISO_DATE); // e.g., "2023-01-01"
        String endOfYear = now.withDayOfYear(now.lengthOfYear()).format(DateTimeFormatter.ISO_DATE); // e.g., "2023-12-31"

        model.addAttribute("startOfYear", startOfYear);
        model.addAttribute("endOfYear", endOfYear);

        return "holiday/create";
    }

    @PostMapping("/holiday/store")
    public String store(@ModelAttribute PublicHoliday publicHoliday) {
        publicHolidayService.store(publicHoliday);
        return "redirect:/dashboard";
    }
}
