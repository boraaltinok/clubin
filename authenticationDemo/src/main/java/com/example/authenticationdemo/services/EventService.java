package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.Event;
import com.example.authenticationdemo.models.SpecificEventNotification;
import com.example.authenticationdemo.repositories.ClubRepository;
import com.example.authenticationdemo.repositories.EventRepository;
import com.example.authenticationdemo.repositories.SpecificEventNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    SpecificEventNotificationRepository specificEventNotificationRepository;


    public Event addEventToClub(int club_id, int event_id) {
        Club club = clubRepository.findById(club_id).get();//found the club
        Event event = eventRepository.findById(event_id).get();//found the event
        //event.setDependentClub(club);
        event.assignClub(club);
        clubRepository.save(club);
        return eventRepository.save(event);
    }

    public List<Event> displayAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> displaySpecificClubsEvents(int club_id) {
        Club specificClub = clubRepository.findById(club_id).get();
        return List.copyOf(specificClub.getClubEvents());//casting set to list
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event assignExistingEventToClub(int club_id,int event_id){
        Event event = eventRepository.findById(event_id).get();
        Club club = clubRepository.findById(club_id).get();

        assignEventsNotification(club_id, event_id);
        System.out.println(club.toString());
        System.out.println(event.toString());
        event.setDependentClub(club);
        club.addToClubEvents(event);
        clubRepository.save(club);
        return eventRepository.save(event);

    }

    private void assignEventsNotification(int club_id, int event_id) {
        Event event = eventRepository.findById(event_id).get();
        Club club = clubRepository.findById(club_id).get();
        String clubName = club.getName();
        String eventName = event.getName();
        String eventDescription = event.getDescription();
        SpecificEventNotification specificEventNotification = new SpecificEventNotification(true,event,clubName, eventName, eventDescription);
        specificEventNotificationRepository.save(specificEventNotification);
        event.setSpecificEventNotification(specificEventNotification);
        eventRepository.save(event);
        clubRepository.save(club);
    }
}
