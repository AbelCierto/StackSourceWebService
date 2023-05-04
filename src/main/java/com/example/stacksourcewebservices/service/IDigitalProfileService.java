package com.example.stacksourcewebservices.service;

import com.example.stacksourcewebservices.entities.DigitalProfile;

import java.util.Optional;

public interface IDigitalProfileService extends CrudService<DigitalProfile> {

    Optional<DigitalProfile> findDigitalProfileByDeveloperId(Long id) throws Exception;
}
