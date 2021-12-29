package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.DeanOffice;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.models.StudentActivityCenter;
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

    public User addUser(int user_id, User reg) {
        User user = reg;
        if(user_id > 10000000){
            Student student = new Student();
            user= student;
        }
        else if(user_id > 100){
            DeanOffice deanOffice = new DeanOffice();
            user = deanOffice;
        }
        else{
            StudentActivityCenter studentActivityCenter = new StudentActivityCenter();
            user = studentActivityCenter;
        }
        return user;
    }
}
