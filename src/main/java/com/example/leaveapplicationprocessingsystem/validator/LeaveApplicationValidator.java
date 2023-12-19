//package com.example.leaveapplicationprocessingsystem.validator;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
//import java.time.LocalDate;
//
//public class LeaveApplicationValidator implements Validator {
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return LeaveApplication.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        LeaveApplication leaveApplication = (LeaveApplication) target;
//
//        LocalDate startDate = leaveApplication.getStartDate();
//        LocalDate endDate = leaveApplication.getEndDate();
//        String leaveReason = leaveApplication.getLeaveReason();
//
//        // Check for null values
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "startDate.empty", "Start date is required.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "endDate.empty", "End date is required.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leaveReason", "leaveReason.empty", "Leave Reason is required.");
//
//        // Check if start date is before end date
//        if (startDate != null && endDate != null && leaveReason != null) {
//            if (startDate.isAfter(endDate)) {
//                errors.rejectValue("startDate", "startDate.afterEndDate", "Start date cannot be after end date.");
//            }
//        }
//    }
//}
//
