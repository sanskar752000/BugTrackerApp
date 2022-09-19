package com.example.BugTrackingApp.serviceImpl;

import com.example.BugTrackingApp.dao.IApplicationDAO;
import com.example.BugTrackingApp.entity.Application;
import com.example.BugTrackingApp.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    private IApplicationDAO applicationDAO;

    @Override
    public synchronized boolean addApplication(Application app) {
        if(applicationDAO.applicationExists(app.getName(), app.getOwner())) {
            return false;
        } else {
            applicationDAO.addApplication(app);
            return true;
        }

    }
}
