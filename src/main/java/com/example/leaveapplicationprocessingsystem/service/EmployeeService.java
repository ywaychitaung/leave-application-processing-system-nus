package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeesByManager(Integer managerId);

    Employee findByEmployeeId(Integer employeeId);

    Employee findByUserId(Integer userId);
}
