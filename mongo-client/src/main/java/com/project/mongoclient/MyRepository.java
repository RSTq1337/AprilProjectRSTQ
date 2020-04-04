package com.project.mongoclient;

import com.project.mongoclient.body.Info;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MyRepository extends MongoRepository<Info, String> {

    @Override
    Optional<Info> findById(String o);

    @Override
    List<Info> findAll();
}
