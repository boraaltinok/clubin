package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.ClubManager;
import com.example.authenticationdemo.models.Event;
import com.example.authenticationdemo.requests.EventCreateRequest;
import com.example.authenticationdemo.services.ClubManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class ClubManagerController {
    @Autowired
    ClubManagerService clubManagerService;
    //show all clubManager registered on the system

    @GetMapping("allManagers")
    public List<ClubManager>  seeAllManagers(){
        return clubManagerService.seeAllManagers();
    }

    @PostMapping("myClub/addEvent")
    public Club editClub(@RequestBody EventCreateRequest eventCreateRequest){
        return clubManagerService.addEventToClub(eventCreateRequest);
    }

}
