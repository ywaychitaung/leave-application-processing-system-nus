package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.User;
import com.example.leaveapplicationprocessingsystem.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User store(User user, HttpSession session) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findByRoleId(Integer roleId) {
        // Find all users by role ID
        // 通过角色 ID 查找所有用户
        return userRepository.findByRoleId(roleId);
    }

    @Override
    public User findByUserId(Integer userId) {
        return userRepository.findByUserId(userId);
    }
}
