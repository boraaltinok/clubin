package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.Event;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.repositories.ClubRepository;
import com.example.authenticationdemo.repositories.EventRepository;
import com.example.authenticationdemo.requests.EventCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    ClubRepository clubRepository;
    @Autowired
    EventRepository eventRepository;
    public List<Club> displayAllClubs() {
        return clubRepository.findAll();
    }

    public Optional<Club> displaySpecificClub(int club_id) {
        return clubRepository.findById(club_id);
    }


    public void deleteClub(int id) {
        Optional<Club> deletedClub = clubRepository.findById(id);
        clubRepository.deleteById(id);
        clubRepository.delete(deletedClub.get());
    }
    public Club addClub(Club club){
        return clubRepository.save(club);
    }

    public Event addEvent(EventCreateRequest eventCreateRequest, int club_id) {

        Club club = clubRepository.findById(club_id).get();
        Event eventToCreate = new Event();

        eventToCreate.setId(eventCreateRequest.getId());
        club.getClubEvents().add(eventToCreate);
        clubRepository.save(club);

        //TO DO GELENIN EVENT OLUP OLMADIĞINI KONTROL ET
        /*club.getClubEvents().add(event);
        clubRepository.save(club);
        eventRepository.save(event);*/
        return  eventRepository.save(eventToCreate);
    }

    public List<Student> displayRegisteredStudents(int club_id) {
        Club club = clubRepository.findById(club_id).get();
        return List.copyOf(club.getClubMembers());
    }
}
