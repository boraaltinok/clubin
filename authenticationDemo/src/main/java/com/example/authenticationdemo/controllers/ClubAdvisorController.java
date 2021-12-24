package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.models.ClubAdvisor;
import com.example.authenticationdemo.services.ClubAdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ClubAdvisorController {
    @Autowired
    ClubAdvisorService clubAdvisorService;
    @PostMapping("/addClubAdvisor")
    public ClubAdvisor addClubAdvisor(@RequestBody ClubAdvisor clubAdvisor){

        return clubAdvisorService.addClubAdvisor(clubAdvisor);
    }
}
