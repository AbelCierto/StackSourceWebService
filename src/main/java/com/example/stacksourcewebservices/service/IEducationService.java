package com.example.stacksourcewebservices.service;

import com.example.stacksourcewebservices.entities.Education;

import java.util.Optional;

public interface IEducationService extends CrudService<Education> {
    Optional<Education> findByDigitalProfileId(Long id) throws Exception;
}
