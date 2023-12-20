package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.Role;
import com.example.leaveapplicationprocessingsystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // Get all roles
    // 获取所有角色
    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Get role name by role ID
    // 通过角色 ID 获取角色名称
    @Override
    @Transactional
    public Role getRoleNameByRoleId(Integer roleId) {
        return roleRepository.findByRoleId(roleId);
    }
}
