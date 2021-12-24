package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findById(int id);
    //void deleteByStudent_id(int id);


}
