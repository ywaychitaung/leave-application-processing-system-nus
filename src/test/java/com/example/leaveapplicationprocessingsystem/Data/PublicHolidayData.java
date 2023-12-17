package com.example.leaveapplicationprocessingsystem.Data;

import com.example.leaveapplicationprocessingsystem.entity.PublicHoliday;
import com.example.leaveapplicationprocessingsystem.repository.PublicHolidayRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublicHolidayData {
    @Autowired
    private PublicHolidayRepository publicHolidayRepository;

    @Test
    public void createPublicHolidayData() {
        PublicHoliday newYear = new PublicHoliday();
        newYear.setPublicHolidayName("New Year's Day");
        newYear.setPublicHolidayDate("2023-01-01");

        PublicHoliday christmas = new PublicHoliday();
        christmas.setPublicHolidayName("Christmas Day");
        christmas.setPublicHolidayDate("2023-12-25");

        // Save the public holidays
        publicHolidayRepository.save(newYear);
        publicHolidayRepository.save(christmas);
    }
}
