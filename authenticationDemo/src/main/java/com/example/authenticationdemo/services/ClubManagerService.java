package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.repositories.ClubManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubManagerService {
    @Autowired
    ClubManagerRepository clubManagerRepository;
}
