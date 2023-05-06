package com.example.stacksourcewebservice.service;

import com.example.stacksourcewebservice.entities.Post;

import java.util.List;

public interface IPostService extends CrudService<Post> {
    List<Post> findByCompany_Id(Long company_id) throws Exception;
}