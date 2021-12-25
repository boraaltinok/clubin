package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.StudentActivityCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentActivityCenterRepository extends JpaRepository<StudentActivityCenter, Integer> {
}
