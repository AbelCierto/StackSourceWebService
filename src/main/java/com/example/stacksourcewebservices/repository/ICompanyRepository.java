package com.example.stacksourcewebservices.repository;

import com.example.stacksourcewebservices.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
