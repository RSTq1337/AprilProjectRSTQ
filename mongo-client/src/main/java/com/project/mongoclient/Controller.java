package com.project.mongoclient;


import com.project.mongoclient.body.Field;
import com.project.mongoclient.body.Info;
import com.project.mongoclient.body.Values;
import com.project.mongoclient.model.Form;
import com.project.mongoclient.model.Result;
import com.project.mongoclient.repos.MyRepository;
import com.project.mongoclient.repos.NewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.UnexpectedTypeException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controller {

    private final NewRepo newRepo;
    private final MyRepository myRepository;

    public Controller(MyRepository myRepository, NewRepo newRepo) {
        this.myRepository = myRepository;
        this.newRepo = newRepo;
    }

    @GetMapping("/meta")
    public Info getMeta(){
         return myRepository.findAll().get(0);
    }

    @PostMapping("/data")
    public Result postMeta(@RequestBody Form form) {
        Result result = new Result();
        result.setResult("успешно");
        List<Field> fields = myRepository.findAll().get(0).getFields();
        Map<String, String> data = form.getForm();
        for (String fieldName : data.keySet()) {
            Optional<Field> any = fields.stream().filter(field -> field.getName().equals(fieldName)).findAny();
            if (any.isPresent()) {
                Field field = any.get();
                if (field.getType().equals("LIST")) {
                    String fieldValue = data.get(fieldName);
                    Values values = field.getValues();
                    if (!(fieldValue.equals(values.getV1()) ||
                            fieldValue.equals(values.getV2()) ||
                            fieldValue.equals(values.getV3()) ||
                            fieldValue.equals(values.getNone()))) {
                        result.setResult("ошибка");
                        break;
                    }
                }
            } else {
                result.setResult("ошибка");
                break;
            }
        }
        if("успешно".equals(result.getResult())){
            newRepo.save(form);
        }
        return result;
    }
}
