package com.example.stacksourcewebservices.repository;

import com.example.stacksourcewebservices.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeveloperRepository extends JpaRepository<Developer, Long> {
}
