package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String login() {
        // Return the login view
        // 返回登录视图
        return "login";
    }

    @PostMapping("/login")
    // RequestParam: Get the form data
    // RequestParam：获取表单数据
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        // Login Service: Check the user credentials and return home if successful else return login with error message
        // 登录服务：检查用户凭据并在成功时返回主页，否则返回带有错误消息的登录
        if (loginService.login(email, password, session)) {
            return "redirect:/dashboard"; // Name of the success view
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login"; // Name of the login view with error message
        }
    }
}
