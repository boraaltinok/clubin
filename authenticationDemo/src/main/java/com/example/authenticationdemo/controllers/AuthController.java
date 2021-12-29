package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.models.User;
import com.example.authenticationdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthController {
    @Autowired
    UserService userService;


    @PostMapping("/addUser/user_id={user_id}")
    public User addUser(@PathVariable int user_id, @RequestBody User registeredUser){
        return userService.addUser(user_id,registeredUser);
    }
}
