package com.project.mongoclient.repos;

import com.project.mongoclient.model.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NewRepo extends MongoRepository<Form, String> {

}
