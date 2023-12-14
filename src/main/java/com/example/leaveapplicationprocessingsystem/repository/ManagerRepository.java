package com.example.leaveapplicationprocessingsystem.repository;

import com.example.leaveapplicationprocessingsystem.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
