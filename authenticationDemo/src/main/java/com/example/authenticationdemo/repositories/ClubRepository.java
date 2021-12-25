package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {
    Optional<Club> findById(int id);
    List<Student> findClubMembersById(int id);
}
