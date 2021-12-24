package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.models.Event;
import com.example.authenticationdemo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/displayAllEvents")
    public List<Event> displayAllEvents(){
        return eventService.displayAllEvents();
    }

    @GetMapping("/displaySpecificClubsEvents/club_id={club_id}")
    public List<Event> displaySpecificClubsEvents(@PathVariable int club_id){
        return eventService.displaySpecificClubsEvents(club_id);
    }

    @PutMapping("addEventToClub/club_id={club_id}/event_id={event_id}")
    public Event addEventToClub(int club_id, int event_id){
        return eventService.addEventToClub(club_id, event_id);
    }

    @PostMapping("/createEvent")
    public Event createEvent(@RequestBody Event event){
        return eventService.createEvent(event);
    }

    @PutMapping("/assignExistingEventToClub/club_id={club_id}/event_id={event_id}")
    public Event assignExistingEventToClub(@PathVariable int club_id, @PathVariable int event_id){
        return eventService.assignExistingEventToClub(club_id,event_id);
    }

}
