package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.PublicHoliday;
import com.example.leaveapplicationprocessingsystem.repository.PublicHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicHolidayServiceImpl implements PublicHolidayService {
    @Autowired
    private PublicHolidayRepository publicHolidayRepository;

    @Override
    public PublicHoliday store(PublicHoliday publicHoliday) {
        return publicHolidayRepository.save(publicHoliday);
    }
}
