package com.project.mongoclient;

import com.project.mongoclient.body.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final MyRepository myRepository;

    public Controller(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    @GetMapping("/meta")
    public Info getMeta(){
         return myRepository.findAll().get(0);
    }
}
