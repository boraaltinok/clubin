package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
    Optional<User> findById(int id);
    Optional<User> deleteById(int id);
}
