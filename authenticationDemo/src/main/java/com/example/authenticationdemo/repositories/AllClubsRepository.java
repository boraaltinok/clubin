package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AllClubsRepository extends JpaRepository<Club, Integer> {
    Optional<Club> findById(int id);
}
