package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.ClubAdvisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubAdvisorRepository extends JpaRepository<ClubAdvisor, Integer> {
    @Override
    Optional<ClubAdvisor> findById(Integer integer);
}
