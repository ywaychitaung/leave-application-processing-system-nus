package com.example.leaveapplicationprocessingsystem.Repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leaveapplicationprocessingsystem.Entity.application;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<application, Long> {
    List<application> findByManagerId(Long managerId);
}
