package com.example.leaveapplicationprocessingsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {
    @PostMapping("/logout")
    // Logout Service: Invalidate the session and return to login page
    // 注销服务：使会话无效并返回登录页面
    public String logout(HttpSession session) {
        // Invalidate the session and clear any data stored in it
        // 使会话无效并清除其中存储的任何数据
        session.invalidate();

        // Redirect to the login page or home page after logout
        // 注销后重定向到登录页面或主页
        return "redirect:/";
    }
}
