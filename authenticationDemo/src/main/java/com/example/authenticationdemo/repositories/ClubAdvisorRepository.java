package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.ClubAdvisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubAdvisorRepository extends JpaRepository<ClubAdvisor, Integer> {
    @Override
    Optional<ClubAdvisor> findById(Integer integer);
}
