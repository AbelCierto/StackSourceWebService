package com.example.stacksourcewebservices.service;

import com.example.stacksourcewebservices.entities.Project;

import java.util.List;

public interface IProjectService extends CrudService<Project> {
    List<Project> findByDigitalProfileId(Long id) throws Exception;
}
