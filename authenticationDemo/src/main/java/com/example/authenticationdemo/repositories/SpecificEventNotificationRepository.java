package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.SpecificEventNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecificEventNotificationRepository extends JpaRepository<SpecificEventNotification, Integer> {
    Optional<SpecificEventNotification> findById(int id);
}
