package com.example.stacksourcewebservices.service;


import com.example.stacksourcewebservices.entities.Certificate;

import java.util.List;

public interface ICertificateService extends CrudService<Certificate> {
    List<Certificate> findByEducationId(Long id) throws Exception;
}


