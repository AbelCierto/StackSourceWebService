package com.example.stacksourcewebservices.service;

import com.example.stacksourcewebservices.entities.Framework;

import java.util.List;

public interface IFrameworkService extends CrudService<Framework> {
    List<Framework> findByDigitalProfileId(Long id) throws Exception;
    List<Framework> findByName(String name) throws Exception;
    List<Framework> findByDeveloperId(Long id) throws Exception;
}
