package com.example.stacksourcewebservice.repository;

import com.example.stacksourcewebservice.entities.DigitalProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDigitalProfileRepository extends JpaRepository<DigitalProfile,Long> {
    Optional<DigitalProfile> findDigitalProfileByDeveloperId(Long id);

    List<DigitalProfile> findDigitalProfilesBy();
}

