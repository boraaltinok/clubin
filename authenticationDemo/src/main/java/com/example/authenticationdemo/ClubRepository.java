package com.example.authenticationdemo;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);
}
