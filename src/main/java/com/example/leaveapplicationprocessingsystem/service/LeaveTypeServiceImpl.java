package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveType;
import com.example.leaveapplicationprocessingsystem.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Override
    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    @Override
    public LeaveType findByLeaveTypeId(Integer leaveTypeId) {
        return leaveTypeRepository.findByLeaveTypeId(leaveTypeId);
    }
}
