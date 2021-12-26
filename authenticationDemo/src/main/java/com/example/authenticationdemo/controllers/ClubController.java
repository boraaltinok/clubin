package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.Event;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.requests.EventCreateRequest;
import com.example.authenticationdemo.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class ClubController {
    //provided REST API for ClubControl mechanism. Clubs are going to be created, deleted or updated
    //via this class.
    @Autowired
    ClubService clubService;

    @GetMapping("/findStudentsOfClub/club_id={club_id}")
    public List<Student> displayRegisteredStudents(@PathVariable int club_id){
        return clubService.displayRegisteredStudents(club_id);
    }
    @GetMapping("/allClubs")
    public List<Club> displayAllClubs(){
        return clubService.displayAllClubs();
    }

    @GetMapping("findSpecificClub/club_id={club_id}")
    public Optional<Club> displaySpecificClub(@PathVariable int club_id){
        return clubService.displaySpecificClub(club_id);
    }

    @DeleteMapping ("/deleteSpecificClub/club_id={id}")
    public String deleteClub(@PathVariable int id){
        clubService.deleteClub(id);
        return "deleted clubs's id : "+ id;
    }
    @PostMapping("/addClub")
    public Club addClub(@RequestBody Club club){
        return clubService.addClub(club);
    }

    @PutMapping("/addEvent/club_id={club_id}")
    public Event addEvent(@RequestBody EventCreateRequest eventCreateRequest, @PathVariable int club_id){
        return clubService.addEvent(eventCreateRequest, club_id);
    }
}
