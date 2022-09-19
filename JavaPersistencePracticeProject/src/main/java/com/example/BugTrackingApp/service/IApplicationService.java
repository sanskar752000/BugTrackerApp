package com.example.BugTrackingApp.service;

import com.example.BugTrackingApp.entity.Application;
import org.springframework.stereotype.Service;

public interface IApplicationService {
    boolean addApplication(Application app);
}
