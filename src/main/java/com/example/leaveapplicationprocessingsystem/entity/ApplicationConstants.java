package com.example.leaveapplicationprocessingsystem.entity;

public class ApplicationConstants {
    public enum LeaveType {
        ANNUAL_LEAVE("annual leave"),
        MEDICAL_LEAVE("medical leave"),
        COMPENSATION_LEAVE("compensation leave");

        private final String displayName;

        LeaveType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum UserRole {
        ADMINISTRATORS, MANAGERS, EMPLOYEES;
    }
}

