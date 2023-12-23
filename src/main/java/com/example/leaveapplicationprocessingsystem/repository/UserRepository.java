package com.example.leaveapplicationprocessingsystem.repository;

import com.example.leaveapplicationprocessingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
        //  Find user by email
        //  通过电子邮件查找用户
        User findByEmail(String email);

        // Find user by role ID
        // 通过角色 ID 查找用户
        List<User> findByRoleId(Integer roleId);
}
