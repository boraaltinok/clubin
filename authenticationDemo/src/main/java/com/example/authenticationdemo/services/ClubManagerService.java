package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.*;
import com.example.authenticationdemo.repositories.ClubManagerRepository;
import com.example.authenticationdemo.requests.EventCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubManagerService {
    @Autowired
    ClubManagerRepository clubManagerRepository;
    ClubService clubService;

    public ClubManagerService(ClubManagerRepository clubManagerRepository,
                              ClubService clubService){
        this.clubManagerRepository = clubManagerRepository;
        this.clubService = clubService;
    }

    public ClubManager createManager(ClubManager manager){
        return clubManagerRepository.save(manager);
    }


    public List<ClubManager> seeAllManagers() {
        return clubManagerRepository.findAll();
    }

    public Club addEventToClub(EventCreateRequest eventCreateRequest) {
        Club club = clubService.displaySpecificClub(eventCreateRequest.getClub_id()).orElse(null);
        /*if(club != null){
            CreateEventForm eventForm =
        }

         */
        return null;
    }

}
