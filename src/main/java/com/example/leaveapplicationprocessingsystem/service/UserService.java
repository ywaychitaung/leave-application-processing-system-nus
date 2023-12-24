package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface UserService {
    User store(User user, HttpSession session);

    User findByUserId(Integer userId);

    // Find user by role ID
    // 通过角色 ID 查找用户
    List<User> findByRoleId(Integer roleId);
}
