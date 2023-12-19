package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.ApplicationConstants;
import com.example.leaveapplicationprocessingsystem.entity.User;
import com.example.leaveapplicationprocessingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PutMapping("/changePassword/{userId}")
    public User changePassword(@PathVariable Integer userId, @RequestParam String newPassword) {
        return userService.changePassword(userId, newPassword);
    }

    @PutMapping("/changeEmail/{userId}")
    public User changeEmail(@PathVariable Integer userId, @RequestParam String newEmail) {
        return userService.changeEmail(userId, newEmail);
    }

    @PutMapping("/changeRole/{userId}")
    public User changeRole(@PathVariable Integer userId, @RequestParam ApplicationConstants.UserRole newRole) {
        return userService.changeRole(userId, newRole);
    }
}
