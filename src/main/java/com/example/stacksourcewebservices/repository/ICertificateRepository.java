package com.example.stacksourcewebservices.repository;

import com.example.stacksourcewebservices.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findByEducationId(Long id);

}

