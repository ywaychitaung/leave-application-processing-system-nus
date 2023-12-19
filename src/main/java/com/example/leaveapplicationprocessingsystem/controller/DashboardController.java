package com.example.leaveapplicationprocessingsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    // Dashboard Service: Return the dashboard view
    // 仪表板服务：返回仪表板视图
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        model.addAttribute("email", session.getAttribute("email"));
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("roleId", session.getAttribute("roleId"));

        // Return the dashboard view
        // 返回仪表板视图
        return "dashboard";
    }
}
