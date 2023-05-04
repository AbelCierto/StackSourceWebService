package com.example.stacksourcewebservices.service;

import com.example.stacksourcewebservices.entities.SocialNetwork;

import java.util.List;

public interface ISocialNetworkService extends CrudService<SocialNetwork> {
    List<SocialNetwork> findSocialNetworkByName(String name_social_network) throws Exception;

    List<SocialNetwork> findByUserId(Long id) throws Exception;
}
