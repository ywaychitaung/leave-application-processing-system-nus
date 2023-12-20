# Leave Entitlement API Usage

## Overview
This document outlines how to use the Leave Entitlement Controller to update leave balances for users. There are three endpoints, each corresponding to a different type of leave.

## Leave Entitlement Endpoints

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

## User Endpoints

### Register User
- **Endpoint**: `POST /user/register`
- **Description**: Register a new user and initialize their leave entitlements.
- **Request Body Example**:
  ```json
  {
    "email": "example@email.com",
    "username": "exampleUser",
    "password": "examplePassword",
    "roleId": 1,
    "role": "EMPLOYEES" // Roles: ADMINISTRATORS, MANAGERS, EMPLOYEES
  }
  ```

### Change Password
- **Endpoint**: `PUT /user/changePassword/{userId}`
- **Description**: Update the password for a user.
- **Parameters**:
  - `userId` - User's unique identifier
- **Request Parameter**: `newPassword` - The new password for the user.
  ```json
  {
    "newPassword": "newPassword123"
  }
  ```

### Change Email
- **Endpoint**: `PUT /user/changeEmail/{userId}`
- **Description**: Update the email for a user.
- **Parameters**:
  - `userId` - User's unique identifier
- **Request Parameter**: `newEmail` - The new email for the user.
  ```json
  {
    "newEmail": "newemail@example.com"
  }
  ```

### Change Role
- **Endpoint**: `PUT /user/changeRole/{userId}`
- **Description**: Update the role for a user.
- **Parameters**:
  - `userId` - User's unique identifier
- **Request Parameter**: `newRole` - The new role for the user. (ADMINISTRATORS, MANAGERS, EMPLOYEES)
  ```json
  {
    "newRole": "MANAGERS"
  }
  ```

## Usage Notes
- Ensure the provided `userId` matches the intended user for updates.
- The roles and other parameters should conform to the expected formats and types.
```
