package com.example.leaveapplicationprocessingsystem.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private String position;

    @OneToMany(mappedBy = "employee")
    private List<application> applications;

    public Employee() {
        // 默认构造器
    }

    // Standard getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<application> getApplications() {
        return applications;
    }

    public void setApplications(List<application> applications) {
        this.applications = applications;
    }
}