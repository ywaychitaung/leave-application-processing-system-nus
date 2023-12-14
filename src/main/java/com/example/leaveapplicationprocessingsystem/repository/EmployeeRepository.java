package com.example.leaveapplicationprocessingsystem.repository;

import com.example.leaveapplicationprocessingsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
