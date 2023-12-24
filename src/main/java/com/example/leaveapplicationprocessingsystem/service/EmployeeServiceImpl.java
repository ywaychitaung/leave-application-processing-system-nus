package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.Employee;
import com.example.leaveapplicationprocessingsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByManager(Integer managerId) {
        return employeeRepository.findByManagerId(managerId);
    }

    @Override
    public Employee findByEmployeeId(Integer employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Employee findByUserId(Integer userId) {
        return employeeRepository.findByUserId(userId);
    }
}
