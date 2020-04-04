package com.project.mongoclient.repos;

import com.project.mongoclient.body.Info;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MyRepository extends MongoRepository<Info, String> {

    @Override
    List<Info> findAll();


}
