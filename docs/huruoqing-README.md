# Leave Entitlement API Usage

## Overview
This document outlines how to use the Leave Entitlement Controller to update leave balances for users. There are three endpoints, each corresponding to a different type of leave.

## Endpoints

### Update Annual Leave
- **Endpoint**: `PUT /leaveEntitlement/update/annual/{userId}`
- **Parameter**: `userId` - User's unique identifier
- **Request Parameter Example**:
    - annualLeave: 10

### Update Medical Leave
- **Endpoint**: `PUT /leaveEntitlement/update/medical/{userId}`
- **Parameter**: `userId` - User's unique identifier
- **Request Parameter Example**:
    - medicalLeave: 5

### Update Compensation Leave
- **Endpoint**: `PUT /leaveEntitlement/update/compensation/{userId}`
- **Parameter**: `userId` - User's unique identifier
- **Request Parameter Example**:
    - compensationLeave: 3

## Usage Notes
- Replace `{userId}` in the endpoint URL with the actual user ID.
- The numbers in the request parameters represent the new leave balance for the user.
- Ensure correct authentication and authorization when calling these endpoints.