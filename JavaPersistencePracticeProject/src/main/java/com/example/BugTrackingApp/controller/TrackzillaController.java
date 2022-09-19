package com.example.BugTrackingApp.controller;

import com.example.BugTrackingApp.entity.Application;
import com.example.BugTrackingApp.service.IApplicationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tza")
public class TrackzillaController {

    @Autowired
    private IApplicationService applicationService;

    @PostMapping("/application")
    public ResponseEntity<Void> addApplication(@RequestBody Application app, UriComponentsBuilder builder) {
        boolean flag = applicationService.addApplication(app);
        if(!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/application/{id}").buildAndExpand(app.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
