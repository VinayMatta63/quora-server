package com.example.userservice.repository;

import com.example.userservice.entity.Follower;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends MongoRepository<Follower,String> {
    List<Follower> findByEmail(String email);
    List<Follower> findByOrgId(String orgid);

}
