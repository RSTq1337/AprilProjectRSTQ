package com.project.mongoclient.body;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Info {
    private String title;
    private String image;
    private List<Field> fields;

}
