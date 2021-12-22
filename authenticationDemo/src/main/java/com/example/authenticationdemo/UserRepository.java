package com.example.authenticationdemo;

import com.example.authenticationdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    Optional<User> findById(int id);
    Optional<User> deleteById(int id);
}
