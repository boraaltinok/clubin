package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.ClubManager;
import com.example.authenticationdemo.models.User;
import com.example.authenticationdemo.repositories.ClubManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
