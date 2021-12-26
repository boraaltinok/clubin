package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.services.SpecificEventNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecificEventNotificationController {
    @Autowired
    SpecificEventNotificationService specificEventNotificationService;

}
