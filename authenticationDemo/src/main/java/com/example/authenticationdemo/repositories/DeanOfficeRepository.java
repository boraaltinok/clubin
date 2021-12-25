package com.example.authenticationdemo.repositories;

import com.example.authenticationdemo.models.DeanOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DeanOfficeRepository extends JpaRepository<DeanOffice, Integer> {
    @Override
    Optional<DeanOffice> findById(Integer integer);
}
