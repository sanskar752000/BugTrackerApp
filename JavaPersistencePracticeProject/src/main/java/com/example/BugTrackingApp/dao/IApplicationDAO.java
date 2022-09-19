package com.example.BugTrackingApp.dao;

import com.example.BugTrackingApp.entity.Application;

public interface IApplicationDAO {
    void addApplication(Application app);
    boolean applicationExists(String name, String owner);
}
