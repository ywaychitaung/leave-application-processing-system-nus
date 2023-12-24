package com.example.leaveapplicationprocessingsystem.validator;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;

import java.time.LocalDate;
import java.util.Set;

public class LeaveApplicationValidator {
    private final Set<LocalDate> publicHolidays;

    public LeaveApplicationValidator(Set<LocalDate> publicHolidays) {
        this.publicHolidays = publicHolidays;
    }

    public boolean validate(LeaveApplication leaveApplication) {
        return validateMandatoryDetails(leaveApplication)
                && validateLeavePeriod(leaveApplication.getStartDate(), leaveApplication.getEndDate());
    }

    private boolean validateMandatoryDetails(LeaveApplication leaveApplication) {
        return isPeriodValid(leaveApplication.getStartDate(), leaveApplication.getEndDate())
                && isReasonValid(leaveApplication.getLeaveReason())
                && isTypeValid(leaveApplication.getLeaveTypeId());
    }

    private boolean isPeriodValid(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return false;
        }
        // Ensure the end date is not before the start date and both dates are not in the past
        return !startDate.isAfter(endDate) && !startDate.isBefore(LocalDate.now());
    }

    private boolean isReasonValid(String reason) {
        return reason != null && !reason.trim().isEmpty();
    }

    private boolean isTypeValid(Integer type) {
        return type != null;
    }

    public boolean validateLeavePeriod(LocalDate startDate, LocalDate endDate) {
        // Calculate the duration of the leave
        int duration = calculateDurationExcludingWeekendsAndHolidays(startDate, endDate);

        // Check if the leave period is less than or equal to 14 days
        if (duration <= 14) {
            return true; // Valid as weekends and public holidays are excluded
        } else {
            return duration == calculateTotalDurationIncludingWeekends(startDate, endDate); // Check with weekends included
        }
    }

    private int calculateDurationExcludingWeekendsAndHolidays(LocalDate start, LocalDate end) {
        int days = 0;
        LocalDate date = start;
        while (!date.isAfter(end)) {
            if (!isWeekend(date) && !publicHolidays.contains(date)) {
                days++;
            }
            date = date.plusDays(1);
        }
        return days;
    }

    private int calculateTotalDurationIncludingWeekends(LocalDate start, LocalDate end) {
        return (int) start.datesUntil(end.plusDays(1)).count();
    }

    private boolean isWeekend(LocalDate date) {
        return switch (date.getDayOfWeek()) {
            case SATURDAY, SUNDAY -> true;
            default -> false;
        };
    }
}
