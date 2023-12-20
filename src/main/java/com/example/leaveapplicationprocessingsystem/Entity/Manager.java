package com.example.leaveapplicationprocessingsystem.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;

    @OneToMany(mappedBy = "manager")
    private List<application> approvedApplications;

    public Manager() {
    }


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

    public List<application> getApprovedApplications() {
        return approvedApplications;
    }

    public void setApprovedApplications(List<application> approvedApplications) {
        this.approvedApplications = approvedApplications;
    }
}
