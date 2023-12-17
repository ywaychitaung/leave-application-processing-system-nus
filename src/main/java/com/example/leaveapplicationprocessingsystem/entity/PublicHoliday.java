package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "public_holidays")
public class PublicHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publicHolidayId;
    private String publicHolidayName;
    private String publicHolidayDate;

    public PublicHoliday() {}

    public PublicHoliday(Integer publicHolidayId,
                         String publicHolidayName,
                         String publicHolidayDate) {
        this.publicHolidayId = publicHolidayId;
        this.publicHolidayName = publicHolidayName;
        this.publicHolidayDate = publicHolidayDate;
    }

    public Integer getPublicHolidayId() { return publicHolidayId; }

    public void setPublicHolidayId(Integer publicHolidayId) { this.publicHolidayId = publicHolidayId; }

    public String getPublicHolidayName() { return publicHolidayName; }

    public void setPublicHolidayName(String publicHolidayName) { this.publicHolidayName = publicHolidayName; }

    public String getPublicHolidayDate() { return publicHolidayDate; }

    public void setPublicHolidayDate(String publicHolidayDate) { this.publicHolidayDate = publicHolidayDate; }
}
