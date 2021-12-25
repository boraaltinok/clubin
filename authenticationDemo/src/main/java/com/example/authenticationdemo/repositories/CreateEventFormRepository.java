package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.CreateEventForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateEventFormRepository extends JpaRepository<CreateEventForm, Integer> {
}
