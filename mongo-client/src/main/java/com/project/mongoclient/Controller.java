package com.project.mongoclient;


import com.project.mongoclient.body.Info;
import com.project.mongoclient.model.Form;
import com.project.mongoclient.repos.MyRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/data")
    public String postMeta(@RequestBody Form form){

    }

}
