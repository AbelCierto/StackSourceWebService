package com.example.stacksourcewebservices.service;

import com.example.stacksourcewebservices.entities.StudyCenter;

import java.util.List;

public interface IStudyCenterService extends CrudService<StudyCenter> {
    List<StudyCenter> findByEducationId(Long id) throws Exception;
}

