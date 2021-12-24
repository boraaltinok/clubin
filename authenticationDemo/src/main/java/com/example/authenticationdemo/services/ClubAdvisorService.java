package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.ClubAdvisor;
import com.example.authenticationdemo.repositories.ClubAdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubAdvisorService {
    @Autowired
    ClubAdvisorRepository clubAdvisorRepository;

    public ClubAdvisorService(ClubAdvisorRepository clubAdvisorRepository) {
        this.clubAdvisorRepository = clubAdvisorRepository;
    }

    public ClubAdvisor addClubAdvisor(ClubAdvisor clubAdvisor) {
        return clubAdvisorRepository.save(clubAdvisor);
    }
}
