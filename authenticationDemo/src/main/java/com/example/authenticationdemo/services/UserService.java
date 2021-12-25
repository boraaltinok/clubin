package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.User;
import com.example.authenticationdemo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findById(int id){
        return userRepository.findById(id).get();
    }
}
