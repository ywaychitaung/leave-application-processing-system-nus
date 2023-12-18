package com.example.leaveapplicationprocessingsystem.Data;

import com.example.leaveapplicationprocessingsystem.entity.Role;
import com.example.leaveapplicationprocessingsystem.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleData {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void createRoleData() {
        Role adminRole = new Role(1, "ADMIN");
        Role userRole = new Role(2, "EMPLOYEE");
        Role guestRole = new Role(3, "MANAGER");

        roleRepository.save(adminRole);
        roleRepository.save(userRole);
        roleRepository.save(guestRole);
    }
}
