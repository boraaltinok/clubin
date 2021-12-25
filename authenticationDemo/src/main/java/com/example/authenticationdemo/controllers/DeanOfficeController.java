package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.services.DeanOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class DeanOfficeController {
    @Autowired
    DeanOfficeService deanOfficeService;
}
