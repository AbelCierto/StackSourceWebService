package com.example.stacksourcewebservices.repository;

import com.example.stacksourcewebservices.entities.StudyCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudyCenterRepository extends JpaRepository<StudyCenter, Long> {
    List<StudyCenter> findByEducationId(Long id);
}
