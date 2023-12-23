package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "public_holidays")
public class PublicHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="public_holiday_id")
    private Integer publicHolidayId;

    @Column(name="public_holiday_name")
    private String publicHolidayName;

    @Column(name="public_holiday_description")
    private String publicHolidayDescription;

    @Column(name="public_holiday_date")
    private String publicHolidayDate;

    public PublicHoliday() {}

    public PublicHoliday(Integer publicHolidayId,
                         String publicHolidayName,
                         String publicHolidayDescription,
                         String publicHolidayDate) {
        this.publicHolidayId = publicHolidayId;
        this.publicHolidayName = publicHolidayName;
        this.publicHolidayDescription = publicHolidayDescription;
        this.publicHolidayDate = publicHolidayDate;
    }

    public Integer getPublicHolidayId() { return publicHolidayId; }

    public void setPublicHolidayId(Integer publicHolidayId) { this.publicHolidayId = publicHolidayId; }

    public String getPublicHolidayName() { return publicHolidayName; }

    public void setPublicHolidayName(String publicHolidayName) { this.publicHolidayName = publicHolidayName; }

    public String getPublicHolidayDescription() { return publicHolidayDescription; }

    public void setPublicHolidayDescription(String publicHolidayDescription) { this.publicHolidayDescription = publicHolidayDescription; }

    public String getPublicHolidayDate() { return publicHolidayDate; }

    public void setPublicHolidayDate(String publicHolidayDate) { this.publicHolidayDate = publicHolidayDate; }
}
