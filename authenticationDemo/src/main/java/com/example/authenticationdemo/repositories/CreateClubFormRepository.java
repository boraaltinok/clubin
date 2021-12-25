package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.CreateClubForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreateClubFormRepository extends JpaRepository<CreateClubForm, Integer> {
    Optional<CreateClubForm> findById(int id);
}
