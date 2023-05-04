package com.example.stacksourcewebservice.repository;

import com.example.stacksourcewebservice.entities.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISocialNetworkRepository extends JpaRepository<SocialNetwork, Long> {
    @Query("select s from SocialNetwork s where s.nameSocialNetwork=:name_social_network")
    List<SocialNetwork> findSocialNetworkByName(@Param("name_social_network") String name_social_network);

    List<SocialNetwork> findByUserId(Long id);
}
